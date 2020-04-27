package cuit.hyl.graduation.project_ui.controller;

import cuit.hyl.graduation.project_ui.entity.*;
import cuit.hyl.graduation.project_ui.service.*;
import cuit.hyl.graduation.project_ui.utils.poi.excel.ExportExcel;
import cuit.hyl.graduation.project_ui.utils.poi.excel.ImportExcel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Api(tags = "Poi操作")
@RestController
@RequestMapping("api/ui/Poi")
public class PoiController {
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
    @PostMapping("exportExcel")
    public ResponseResult exportExcel() {

        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功导出");
    }

    @ApiOperation("导出定制化Excel--个人")
    @PostMapping("exportModelExcel/{type}/{id}")
    public void exportModelExcel(@PathVariable String type,@PathVariable Long id,HttpServletResponse response) {
        response.addHeader("Access-Control-Expose-Headers", "Content-Disposition");
        ExportExcel<BasicInfo> exportExcel = new ExportExcel<>();

        Map<String, Object> param = new HashMap<>();
        param.put("rowStartIndex", 1);
        param.put("response", response);

        switch(type){
            case "BasicInfo":
                List<BasicInfo> BasicInfoList = basicInfoService.queryByPeopleId(id);
                param.put("list", BasicInfoList);
                param.put("fileName","BasicInfo.xlsx");
                param.put("path","static/excel/BasicInfo.xlsx");

                exportExcel.exportByXSSF(param);
                break;
            case "Education":
                List<Education> educationList = educationService.queryAll(id);
                param.put("list", educationList);
                param.put("fileName","Education.xlsx");
                param.put("path","static/excel/Education.xlsx");

                exportExcel.exportByXSSF(param);
                break;
            case "Work":
                List<Work> workList = workService.queryAll(id);
                param.put("list", workList);
                param.put("fileName","Work.xlsx");
                param.put("path","static/excel/Work.xlsx");

                exportExcel.exportByXSSF(param);
                break;
            case "Family":
                Map<String, Object> familyMap = new HashMap<>();
                FamilyBase familyBase = familyBaseService.initInfo(id).get(0);
                familyMap.put("基础信息", familyBaseService.initInfo(id));
                if (familyBase != null){
                    List<FamilyMember> members = familyBaseService.memberByBaseId(familyBase.getId());
                    familyMap.put("家庭成员", members);
                }
                param.put("map", familyMap);
                param.put("fileName","Family.xlsx");
                param.put("path","static/excel/Family.xlsx");

                exportExcel.exportSheetXSSF(param);
                break;
            case "Teaching":
                Map<String, Object> TeachingMap = new HashMap<>();
                Teaching teach = this.teachingService.initTeach(id).get(0);
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
                param.put("map", TeachingMap);
                param.put("fileName","Teaching.xlsx");
                param.put("path","static/excel/Teaching.xlsx");

                exportExcel.exportSheetXSSF(param);
                break;
            case "Research":
                Map<String, Object> researchMap = new HashMap<>();
                Research research = researchService.initInfo(id).get(0);
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
                param.put("map", researchMap);
                param.put("fileName","Research.xlsx");
                param.put("path","static/excel/Research.xlsx");

                exportExcel.exportSheetXSSF(param);
                break;
            case "Awards":
                Map<String, Object> awardsMap = new HashMap<>();
                Awards awards = this.awardsService.initInfo(id).get(0);
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
//                    awardsMap.put("荣誉墙", honorWallList);
                }
                param.put("map", awardsMap);
                param.put("fileName","Awards.xlsx");
                param.put("path","static/excel/Awards.xlsx");

                exportExcel.exportSheetXSSF(param);
                break;
            default:
                System.out.println("没有此类型导出文件！");

        }


    }

    @ApiOperation("导入Excel")
    @PostMapping("importExcel/{type}/{id}")
    public ResponseResult importExcel(@PathVariable String type,@PathVariable Long id, MultipartFile multipartFile) {
        ImportExcel importExcel;
        int num = 0;
        try{
            Map<String, Object> param = new HashMap<>();
            param.put("inputStream", multipartFile.getInputStream());
            param.put("id", id);
            param.put("startIndex", 1);



            switch (type){
                case "BasicInfo":
                    importExcel = new ImportExcel<BasicInfo>();
                    param.put("clazz", BasicInfo.class);
                    List<BasicInfo> list = importExcel.importByXSSF(param);
                    num = basicInfoService.excelImport(list);
                    break;


            }


        }catch (Exception e){
            e.printStackTrace();
            return new ResponseResult(ResponseResult.CodeStatus.FAIL,"操作失败");
        }
        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功导入" + num + "条数据");
    }


}
