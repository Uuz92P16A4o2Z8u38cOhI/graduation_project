package cuit.hyl.graduation.project_ui.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cuit.hyl.graduation.project_ui.entity.*;
import cuit.hyl.graduation.project_ui.service.*;
import cuit.hyl.graduation.project_ui.utils.easypoi.ExcelUtils;
import cuit.hyl.graduation.project_ui.utils.snowflake.SnowflakeIdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Api(tags = "EasyPoi操作")
@RestController
@RequestMapping("api/ui/easyPoi")
public class EasyPoiController {

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
        try {
            switch(type){
                case "BasicInfo":
                    List<BasicInfo> basicInfoList = basicInfoService.queryByPeopleId(id, version);
                    ExcelUtils.exportExcel(basicInfoList, "教师基础信息", "基础信息", BasicInfo.class, "BasicInfo", response );
                    break;
                case "Education":
                    List<Education> educationList = educationService.queryAll(id);
                    ExcelUtils.exportExcel(educationList, "教师受教育情况", "受教育情况", Education.class, "Education", response );
                    break;
                case "Work":
                    List<Work> workList = workService.queryAll(id);
                    ExcelUtils.exportExcel(workList, "教师工作情况", "工作情况", Work.class, "Work", response );
                    break;
                case "Family":
                    List<FamilyBase> familyBaseList = familyBaseService.initInfo(id,version);
//                    FamilyBase familyBase = familyBaseList.get(0);
                    if (familyBaseList != null){
                        for(FamilyBase family : familyBaseList){
                            List<FamilyMember> members = familyBaseService.memberByBaseId(family.getId());
                            family.setFamilyMembers(members);
                        }
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

    @ApiOperation("导入Excel")
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


    }


}
