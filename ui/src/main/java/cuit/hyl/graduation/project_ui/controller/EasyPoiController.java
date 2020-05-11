package cuit.hyl.graduation.project_ui.controller;

import cn.afterturn.easypoi.entity.ImageEntity;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.word.WordExportUtil;
import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.project_ui.entity.*;
import cuit.hyl.graduation.project_ui.entity.vo.UserVo;
import cuit.hyl.graduation.project_ui.service.*;
import cuit.hyl.graduation.project_ui.utils.easypoi.ExcelUtils;
import cuit.hyl.graduation.project_ui.utils.poi.excel.ExportExcel;
import cuit.hyl.graduation.project_ui.utils.snowflake.SnowflakeIdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import static javax.swing.UIManager.get;

@Slf4j
@Api(tags = "EasyPoi操作")
@RestController
@RequestMapping("api/ui/easyPoi")
public class EasyPoiController {

    @Value("${fastdfs.base.url}")
    String fastDFSURL = "http://192.168.91.128:8888/";

    @Autowired
    private BasicInfoService basicInfoService;
    @Autowired
    private EducationService educationService;
    @Autowired
    private WorkService workService;
    @Autowired
    private FamilyBaseService familyBaseService;
    @Autowired
    private TeachingService teachingService;
    @Autowired
    private ResearchService researchService;
    @Autowired
    private AwardsService awardsService;

    @ApiOperation("导出Excel")
    @PostMapping("exportExcel/{type}/{id}/{version}")
    public void exportExcel(@PathVariable String type, @PathVariable Long id, @PathVariable Long version, HttpServletResponse response) {
        response.addHeader("Access-Control-Expose-Headers", "Content-Disposition");
//        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
//        Long id = userVo.getId();
        try {
            switch(type){
                case "BasicInfo":
                    List<BasicInfo> basicInfoList = basicInfoService.queryByPeopleId(id, version);
                    ExcelUtils.exportExcel(basicInfoList, "教师基础信息", "基础信息", BasicInfo.class, "BasicInfo", response );
                    break;
                case "Education":
                    List<Education> educationList = educationService.queryInitInfo(id, version);
//                    List<Education> educationList = educationService.queryAll(id);
                    ExcelUtils.exportExcel(educationList, "教师受教育情况", "受教育情况", Education.class, "Education", response );
                    break;
                case "Work":
                    List<Work> workList = workService.queryInitInfo(id, version);
//                    List<Work> workList = workService.queryAll(id);
                    ExcelUtils.exportExcel(workList, "教师工作情况", "工作情况", Work.class, "Work", response );
                    break;
                case "Family":
                    List<FamilyBase> familyBaseList = familyBaseService.initInfo(id,version);
                    if (familyBaseList != null){
                        FamilyBase familyBase = familyBaseList.get(0);
                        List<FamilyMember> members = familyBaseService.memberByBaseId(familyBase.getId());
                        familyBase.setFamilyMembers(members);
                    }
                    ExcelUtils.exportExcel(familyBaseList, "教师家庭情况", "家庭情况", FamilyBase.class, "Family", response );
                    break;
                case "Teaching":
                    List<Map<String, Object>> teachSheetsList = new ArrayList<>(); //sheets
                    Map<String, Object> TeachingMap = new HashMap<>();
                    Teaching teach = this.teachingService.initTeach(id,version).get(0);
                    if (teach != null){
                        List<TeachingItem> research = this.teachingService.initTeachItem(1, teach.getResearch());
                        List<TeachingItem> resources = this.teachingService.initTeachItem(2, teach.getResources());
                        List<TeachingItem> achievements = this.teachingService.initTeachItem(3, teach .getAchievements());
                        List<TeachingClass> undergraduate = this.teachingService.initTeachClass(1, teach.getClassInfo());
                        List<TeachingClass> postgraduate = this.teachingService.initTeachClass(2, teach.getClassInfo());
                        TeachingMap.put("教学研究", research);
                        TeachingMap.put("教学资源", resources);
                        TeachingMap.put("教学成果", achievements);
                        TeachingMap.put("本科生课程", undergraduate);
                        TeachingMap.put("研究生课程", postgraduate);
                    }
                    for (String key: TeachingMap.keySet()){
                        Map<String, Object> map = new HashMap<>();
                        ExportParams exportParams = new ExportParams();
                        exportParams.setSheetName(key);
                        map.put("title", exportParams);
                        map.put("data",TeachingMap.get(key));
                        switch (key){
                            case "教学研究":
                            case "教学资源":
                            case "教学成果":
                                map.put("entity", TeachingItem.class);
                                break;
                            case "本科生课程":
                            case "研究生课程":
                                map.put("entity", TeachingClass.class);
                                break;
                        }
                        teachSheetsList.add(map);
                    }
//                    ExcelUtils.exportExcel(sheetsList, "Teaching", response);
                    Workbook teachingWorkbook = ExcelExportUtil.exportExcel(teachSheetsList, ExcelType.HSSF);
                    ExcelUtils.downLoadExcelHssf("Teaching", response, teachingWorkbook);
                    break;
                case "Research":
                    List<Map<String, Object>> researchSheetsList = new ArrayList<>(); //sheets
                    Map<String, Object> researchMap = new HashMap<>();
                    Research research = researchService.initInfo(id,version).get(0);
                    if (research != null){
                        List<ResearchItem> researchAreas = researchService.queryItems(research.getResearchAreas() , 1);
                        List<ResearchItem> thesisResults = researchService.queryItems(research.getThesisResults() , 2);
                        List<ResearchItem> patent = researchService.queryItems(research.getPatent() , 3);
                        List<ResearchItem> achievements = researchService.queryItems(research.getAchievements() , 4);
                        List<ResearchItem> researchProjects = researchService.queryItems(research.getResearchProjects() , 5);
                        List<ResearchItem> researchTeam = researchService.queryItems(research.getResearchTeam() , 6);
                        researchMap.put("研究领域", researchAreas);
                        researchMap.put("论文成果", thesisResults);
                        researchMap.put("专利", patent);
                        researchMap.put("著作成果", achievements);
                        researchMap.put("科研项目", researchProjects);
                        researchMap.put("科研团队", researchTeam);
                    }
                    for (String key: researchMap.keySet()) {
                        Map<String, Object> map = new HashMap<>();
                        ExportParams exportParams = new ExportParams();
                        exportParams.setSheetName(key);
                        map.put("title", exportParams);
                        map.put("data", researchMap.get(key));
                        map.put("entity", ResearchItem.class);
                        researchSheetsList.add(map);
                    }
//                    ExcelUtils.exportExcel(researchSheetsList, "Teaching", response);
                    Workbook researchWorkbook = ExcelExportUtil.exportExcel(researchSheetsList, ExcelType.HSSF);
                    ExcelUtils.downLoadExcelHssf("Research", response, researchWorkbook);
                    break;
                case "Awards":
                    List<Map<String, Object>> awardsSheetsList = new ArrayList<>(); //sheets
                    Map<String, Object> awardsMap = new HashMap<>();
                    Awards awards = this.awardsService.initInfo(id,version).get(0);
                    if (awards != null){
                        List<AwardsItem> academicHonorsList = this.awardsService.initItemInfo(awards.getAcademicHonors(), 1);
                        List<AwardsItem> scientificAwardsList = this.awardsService.initItemInfo(awards.getScientificAwards(), 2);
                        List<AwardsItem> otherAwardsList = this.awardsService.initItemInfo(awards.getOtherAwards(), 3);
                        List<AwardsItem> honoraryTitleList = this.awardsService.initItemInfo(awards.getHonoraryTitle(), 4);
                        List<AwardsItem> honorWallList = this.awardsService.initItemInfo(awards.getHonorWall(), 5);

                        awardsMap.put("学术荣誉", academicHonorsList);
                        awardsMap.put("科研奖励", scientificAwardsList);
                        awardsMap.put("其它获奖", otherAwardsList);
                        awardsMap.put("荣誉称号", honoraryTitleList);
                        awardsMap.put("荣誉墙", honorWallList);
                    }
                    for (String key: awardsMap.keySet()) {
                        Map<String, Object> map = new HashMap<>();
                        ExportParams exportParams = new ExportParams();
                        exportParams.setSheetName(key);
                        map.put("title", exportParams);
                        map.put("data", awardsMap.get(key));
                        map.put("entity", AwardsItem.class);
                        awardsSheetsList.add(map);
                    }
                    Workbook awardsWorkbook = ExcelExportUtil.exportExcel(awardsSheetsList, ExcelType.HSSF);
                    ExcelUtils.downLoadExcelHssf("Awards", response, awardsWorkbook);
                    break;
                default:
                    System.out.println("导出失败！");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*@ApiOperation("导入Excel")
    @PostMapping("importExcel/{type}/{id}")
    @Transactional
    public void importExcel(@PathVariable String type, @PathVariable Long id, MultipartFile multipartFile) {
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1,2);
        try {
            switch (type){
                case "BasicInfo":
                    List<BasicInfo> basicInfoList = null;
                    basicInfoList = ExcelUtils.importExcel(multipartFile, 0, 1, BasicInfo.class);
                    if(basicInfoList != null){
                        for(BasicInfo basicInfo: basicInfoList){
                            basicInfo.setId(idWorker.nextId());
                            basicInfo.setPeopleId(id);
                        }
                    }

                    this.basicInfoService.easyPoiExcelImport(basicInfoList);
                    break;
                case "Education":
                    List<Education> educationList = null;
                    educationList = ExcelUtils.importExcel(multipartFile, 0, 1, Education.class);
                    for(Education education: educationList){
                        education.setId(idWorker.nextId());
                        education.setPeopleId(id);
                    }

                    this.educationService.easyExcelImport(educationList);
                    break;
                case "Work":
                    List<Work> workList = null;
                    workList = ExcelUtils.importExcel(multipartFile, 0, 1, Work.class);
                    for(Work work: workList){
                        work.setId(idWorker.nextId());
                        work.setPeopleId(id);
                    }

                    this.workService.easyExcelImport(workList);
                    break;
                case "Family":
                    List<FamilyBase> familyList = null;
                    familyList = ExcelUtils.importExcel(multipartFile, 0, 2, FamilyBase.class);
                    for(FamilyBase family: familyList){
                        family.setId(idWorker.nextId());
                        family.setPeopleId(id);
                        for (FamilyMember member : family.getFamilyMembers()){
                            member.setId(idWorker.nextId());
                            member.setBaseId(family.getId());
                        }
                        this.familyBaseService.easyExcelImportMember(family.getFamilyMembers());
                    }
                    this.familyBaseService.easyExcelImportBase(familyList);


                    break;
            }



        } catch (IOException e) {
            e.printStackTrace();
        }


    }*/



    @ApiOperation("导出word模板")
    @PostMapping("exportModelWord/{type}/{id}/{version}")
    public void exportModelWord(@PathVariable String type, @PathVariable Long id, @PathVariable Long version, HttpServletResponse response) {
        response.addHeader("Access-Control-Expose-Headers", "Content-Disposition");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");

//        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserVo userVo = JSONObject.parseObject(principal, UserVo.class);
//        Long id = userVo.getId();

        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");

        try {
            switch(type){
                case "BasicInfo":
                    List<BasicInfo> basicInfoList = basicInfoService.queryByPeopleId(id, version);
                    Map<String, Object> basicInfoWordMap = new HashMap<String, Object>();
                    if (basicInfoList != null){
                        BasicInfo basicInfo = basicInfoList.get(0);
                        basicInfoWordMap.put("basicInfo", basicInfo);
                        basicInfoWordMap.put("birthday", sdf.format(basicInfo.getBirthday()));
                        School school = basicInfoService.schoolInfo(id);
                        basicInfoWordMap.put("schoolName", school.getName());

                        ImageEntity image = new ImageEntity();
                        image.setHeight(200);
                        image.setWidth(200);
                        image.setUrl(fastDFSURL + basicInfo.getAvatatUrl());
                        image.setType(ImageEntity.URL);
                        basicInfoWordMap.put("avatar", image);

                        XWPFDocument doc = WordExportUtil.exportWord07(
                                Objects.requireNonNull(EasyPoiController.class.getClassLoader().getResource("static/word/BasicInfo.docx").getPath(), "模板文件路径问题")
                                , basicInfoWordMap);

                        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(type, "UTF-8"));
                        doc.write(response.getOutputStream());
                    }
                    break;
                case "Education":
                    List<Education> educationList = educationService.queryInitInfo(id, version);
                    Map<String, Object> educationWordMap = new HashMap<String, Object>();
                    if (educationList != null){
                        educationWordMap.put("education", educationList);
                        XWPFDocument doc = WordExportUtil.exportWord07(
                                Objects.requireNonNull(EasyPoiController.class.getClassLoader().getResource("static/word/BasicInfo.docx").getPath(), "模板文件路径问题")
                                , educationWordMap);
                        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(type, "UTF-8"));
                        doc.write(response.getOutputStream());
                    }
                    break;
                case "Work":
                    List<Work> workList = workService.queryInitInfo(id, version);
                    Map<String, Object> workWordMap = new HashMap<String, Object>();
                    if (workList != null){
                        workWordMap.put("work", workList);
                        XWPFDocument doc = WordExportUtil.exportWord07(
                                Objects.requireNonNull(EasyPoiController.class.getClassLoader().getResource("static/word/BasicInfo.docx").getPath(), "模板文件路径问题")
                                , workWordMap);
                        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(type, "UTF-8"));
                        doc.write(response.getOutputStream());
                    }
                    break;
                case "Family":
                    List<FamilyBase> familyBaseList = familyBaseService.initInfo(id,version);
                    Map<String, Object> familyWordMap = new HashMap<String, Object>();
                    if (familyBaseList != null){
                        FamilyBase familyBase = familyBaseList.get(0);
                        if(familyBase != null){
                            List<FamilyMember> members = familyBaseService.memberByBaseId(familyBase.getId());
                            familyBase.setFamilyMembers(members);
                        }
                        familyWordMap.put("familyBase",familyBase);
                        XWPFDocument doc = WordExportUtil.exportWord07(
                                Objects.requireNonNull(EasyPoiController.class.getClassLoader().getResource("static/word/BasicInfo.docx").getPath(), "模板文件路径问题")
                                , familyWordMap);
                        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(type, "UTF-8"));
                        doc.write(response.getOutputStream());
                    }



                    break;
                case "Teaching":
                    Map<String, Object> TeachingWordMap = new HashMap<>();
                    List<Teaching> teachings = this.teachingService.initTeach(id, version);
                    if (teachings != null){
                        Teaching teach = teachings.get(0);
                        List<TeachingItem> research = this.teachingService.initTeachItem(1, teach.getResearch());
                        List<TeachingItem> resources = this.teachingService.initTeachItem(2, teach.getResources());
                        List<TeachingItem> achievements = this.teachingService.initTeachItem(3, teach .getAchievements());
                        List<TeachingClass> undergraduate = this.teachingService.initTeachClass(1, teach.getClassInfo());
                        List<TeachingClass> postgraduate = this.teachingService.initTeachClass(2, teach.getClassInfo());
                        TeachingWordMap.put("research", research);
                        TeachingWordMap.put("resources", resources);
                        TeachingWordMap.put("achievements", achievements);
                        TeachingWordMap.put("undergraduate", undergraduate);
                        TeachingWordMap.put("postgraduate", postgraduate);

                        XWPFDocument doc = WordExportUtil.exportWord07(
                                Objects.requireNonNull(EasyPoiController.class.getClassLoader().getResource("static/word/BasicInfo.docx").getPath(), "模板文件路径问题")
                                , TeachingWordMap);
                        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(type, "UTF-8"));
                        doc.write(response.getOutputStream());
                    }

                    break;
                case "Research":
                    Map<String, Object> researchWordMap = new HashMap<>();
                    List<Research> researchList = researchService.initInfo(id, version);
                    if (researchList != null){
                        Research research = researchList.get(0);
                        List<ResearchItem> researchAreas = researchService.queryItems(research.getResearchAreas() , 1);
                        List<ResearchItem> thesisResults = researchService.queryItems(research.getThesisResults() , 2);
                        List<ResearchItem> patent = researchService.queryItems(research.getPatent() , 3);
                        List<ResearchItem> achievements = researchService.queryItems(research.getAchievements() , 4);
                        List<ResearchItem> researchProjects = researchService.queryItems(research.getResearchProjects() , 5);
                        List<ResearchItem> researchTeam = researchService.queryItems(research.getResearchTeam() , 6);
                        researchWordMap.put("researchAreas", researchAreas);
                        researchWordMap.put("thesisResults", thesisResults);
                        researchWordMap.put("patent", patent);
                        researchWordMap.put("achievements", achievements);
                        researchWordMap.put("researchProjects", researchProjects);
                        researchWordMap.put("researchTeam", researchTeam);

                        XWPFDocument doc = WordExportUtil.exportWord07(
                                Objects.requireNonNull(EasyPoiController.class.getClassLoader().getResource("static/word/BasicInfo.docx").getPath(), "模板文件路径问题")
                                , researchWordMap);
                        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(type, "UTF-8"));
                        doc.write(response.getOutputStream());
                    }
                    break;
                case "Awards":
                    Map<String, Object> awardsWordMap = new HashMap<>();
                    List<Awards> awardsList = this.awardsService.initInfo(id, version);
                    if (awardsList != null){
                        Awards awards = awardsList.get(0);
                        List<AwardsItem> academicHonorsList = this.awardsService.initItemInfo(awards.getAcademicHonors(), 1);
                        List<AwardsItem> scientificAwardsList = this.awardsService.initItemInfo(awards.getScientificAwards(), 2);
                        List<AwardsItem> otherAwardsList = this.awardsService.initItemInfo(awards.getOtherAwards(), 3);
                        List<AwardsItem> honoraryTitleList = this.awardsService.initItemInfo(awards.getHonoraryTitle(), 4);
                        List<AwardsItem> honorWallList = this.awardsService.initItemInfo(awards.getHonorWall(), 5);

                        awardsWordMap.put("academicHonorsList", academicHonorsList);
                        awardsWordMap.put("scientificAwardsList", scientificAwardsList);
                        awardsWordMap.put("otherAwardsList", otherAwardsList);
                        awardsWordMap.put("honoraryTitleList", honoraryTitleList);
                        awardsWordMap.put("honorWallList", honorWallList);

                        XWPFDocument doc = WordExportUtil.exportWord07(
                                Objects.requireNonNull(EasyPoiController.class.getClassLoader().getResource("static/word/BasicInfo.docx").getPath(), "模板文件路径问题")
                                , awardsWordMap);
                        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(type, "UTF-8"));
                        doc.write(response.getOutputStream());
                    }
                    break;
                default:
                    System.out.println("导出失败！");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
