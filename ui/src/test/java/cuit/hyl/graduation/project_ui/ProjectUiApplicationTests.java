package cuit.hyl.graduation.project_ui;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.project_ui.entity.*;
import cuit.hyl.graduation.project_ui.service.*;
import cuit.hyl.graduation.project_ui.utils.snowflake.SnowflakeIdWorker;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ProjectUiApplicationTests {

    @Test
    void contextLoads() {
        saveVersion(1l, 11111111111111111l);
    }

    SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1, 5);

    @Resource
    private BasicInfoService basicInfoService;

    @Resource
    private EducationService educationService;

    @Resource
    private WorkService workService;

    @Resource
    private FamilyBaseService familyBaseService;

    @Resource
    private TeachingService teachingService;

    @Resource
    private ResearchService researchService;

    @Resource
    private AwardsService awardsService;

    @Test
    @Transactional
    public void saveVersion(Long id, Long version){
        List<BasicInfo> basicInfoList = this.basicInfoService.queryByPeopleId(id, 0l);
        if (basicInfoList.size() != 0){
            BasicInfo basicInfo = basicInfoList.get(0);
            basicInfo.setId(idWorker.nextId());
            basicInfo.setVersion(version);
            this.basicInfoService.insertInitInfo((JSONObject) JSONObject.toJSON(basicInfo));
        }

        List<Education> educationList = this.educationService.queryInitInfo(id,0l);
        if (educationList.size() != 0){
            for (int i = 0; i < educationList.size(); i++) {
                educationList.get(i).setId(idWorker.nextId());
                educationList.get(i).setUploadTime(null);
                educationList.get(i).setVersion(version);
            }
            this.educationService.insertForeach(educationList);
        }

        List<Work> works = this.workService.queryInitInfo(id,0l);
        if (works.size() != 0){
            for (int i = 0; i < works.size(); i++) {
                works.get(i).setId(idWorker.nextId());
                works.get(i).setUploadTime(null);
                works.get(i).setVersion(version);
            }
            this.workService.insertForeach(works);
        }

        List<FamilyBase> familyBases = familyBaseService.initInfo(id, 0l);
        if (familyBases.size() != 0){
            FamilyBase familyBase = familyBases.get(0);

            List<FamilyMember> members = familyBaseService.memberByBaseId(familyBase.getId());

            Long baseId = idWorker.nextId();
            familyBase.setId(baseId);
            familyBase.setUploadTime(null);
            familyBase.setVersion(version);
            this.familyBaseService.insertbase((JSONObject) JSONObject.toJSON(familyBase));

            if (members.size() != 0){
                for (FamilyMember member:members){
                    member.setId(idWorker.nextId());
                    member.setBaseId(baseId);
                    this.familyBaseService.insertItem((JSONObject) JSONObject.toJSON(member));
                }
            }
        }

        List<Teaching> teachings = this.teachingService.initTeach(id, 0l);
        if (teachings.size() != 0){
            Teaching teaching = teachings.get(0);

            List<TeachingItem> research = this.teachingService.initTeachItem(1, teaching.getResearch());
            List<TeachingItem> resources = this.teachingService.initTeachItem(2, teaching.getResources());
            List<TeachingItem> achievements = this.teachingService.initTeachItem(3, teaching .getAchievements());
            List<TeachingClass> undergraduate = this.teachingService.initTeachClass(1, teaching.getClassInfo());
            List<TeachingClass> postgraduate = this.teachingService.initTeachClass(2, teaching.getClassInfo());

            teaching.setId(idWorker.nextId());
            Long achievementsId = idWorker.nextId();
            teaching.setAchievements(achievementsId);
            Long classInfoId = idWorker.nextId();
            teaching.setClassInfo(classInfoId);
            Long researchId = idWorker.nextId();
            teaching.setResearch(researchId);
            Long resourcesId = idWorker.nextId();
            teaching.setResources(resourcesId);
            teaching.setVersion(version);
            teaching.setUploadTime(null);
            this.teachingService.insertTeach(teaching);

            if (research != null){
                for (int i = 0; i < research.size(); i++) {
                    research.get(i).setId(idWorker.nextId());
                    research.get(i).setParentId(researchId);
                    research.get(i).setType(1);
                    this.teachingService.insertTeachItem((JSONObject) JSONObject.toJSON(research.get(i)));
                }
            }
            if (resources != null){
                for (int i = 0; i < resources.size(); i++) {
                    resources.get(i).setId(idWorker.nextId());
                    resources.get(i).setParentId(resourcesId);
                    resources.get(i).setType(2);
                    this.teachingService.insertTeachItem((JSONObject) JSONObject.toJSON(resources.get(i)));
                }
            }
            if (achievements != null){
                for (int i = 0; i < achievements.size(); i++) {
                    achievements.get(i).setId(idWorker.nextId());
                    achievements.get(i).setParentId(achievementsId);
                    achievements.get(i).setType(3);
                    this.teachingService.insertTeachItem((JSONObject) JSONObject.toJSON(achievements.get(i)));
                }
            }

            if (undergraduate != null){
                for (int i = 0; i < undergraduate.size(); i++) {
                    undergraduate.get(i).setId(idWorker.nextId());
                    undergraduate.get(i).setClassInfoId(classInfoId);
                    undergraduate.get(i).setType(1);
                    this.teachingService.insertTeachClass((JSONObject) JSONObject.toJSON(undergraduate.get(i)));
                }
            }
            if (postgraduate != null){
                for (int i = 0; i < postgraduate.size(); i++) {
                    postgraduate.get(i).setId(idWorker.nextId());
                    postgraduate.get(i).setClassInfoId(classInfoId);
                    postgraduate.get(i).setType(2);
                    this.teachingService.insertTeachClass((JSONObject) JSONObject.toJSON(postgraduate.get(i)));
                }
            }
        }

        List<Research> researchList = researchService.initInfo(id, 0l);
        if (researchList.size() != 0) {
            Research research = researchList.get(0);
            List<ResearchItem> researchAreas = researchService.queryItems(research.getResearchAreas(), 1);
            List<ResearchItem> thesisResults = researchService.queryItems(research.getThesisResults(), 2);
            List<ResearchItem> patent = researchService.queryItems(research.getPatent(), 3);
            List<ResearchItem> achievements = researchService.queryItems(research.getAchievements(), 4);
            List<ResearchItem> researchProjects = researchService.queryItems(research.getResearchProjects(), 5);
            List<ResearchItem> researchTeam = researchService.queryItems(research.getResearchTeam(), 6);

            research.setId(idWorker.nextId());
            Long achievementsId = idWorker.nextId();
            research.setAchievements(achievementsId);
            Long patentId = idWorker.nextId();
            research.setPatent(patentId);
            Long researchAreasId = idWorker.nextId();
            research.setResearchAreas(researchAreasId);
            Long researchProjectsId = idWorker.nextId();
            research.setResearchProjects(researchProjectsId);
            Long researchTeamId = idWorker.nextId();
            research.setResearchTeam(researchTeamId);
            Long thesisResultsId = idWorker.nextId();
            research.setThesisResults(thesisResultsId);
            research.setVersion(version);
            research.setUploadTime(null);
            this.researchService.insertResearch(research);

            if (researchAreas != null){
                for (int i = 0; i < researchAreas.size(); i++) {
                    researchAreas.get(i).setId(idWorker.nextId());
                    researchAreas.get(i).setParentId(researchAreasId);
                    researchAreas.get(i).setType(1);
                    this.researchService.insertResearchItem((JSONObject) JSONObject.toJSON(researchAreas.get(i)));
                }
            }
            if (thesisResults != null){
                for (int i = 0; i < thesisResults.size(); i++) {
                    thesisResults.get(i).setId(idWorker.nextId());
                    thesisResults.get(i).setParentId(thesisResultsId);
                    thesisResults.get(i).setType(2);
                    this.researchService.insertResearchItem((JSONObject) JSONObject.toJSON(thesisResults.get(i)));
                }
            }
            if (patent != null){
                for (int i = 0; i < patent.size(); i++) {
                    patent.get(i).setId(idWorker.nextId());
                    patent.get(i).setParentId(patentId);
                    patent.get(i).setType(3);
                    this.researchService.insertResearchItem((JSONObject) JSONObject.toJSON(patent.get(i)));
                }
            }
            if (achievements != null){
                for (int i = 0; i < achievements.size(); i++) {
                    achievements.get(i).setId(idWorker.nextId());
                    achievements.get(i).setParentId(achievementsId);
                    achievements.get(i).setType(4);
                    this.researchService.insertResearchItem((JSONObject) JSONObject.toJSON(achievements.get(i)));
                }
            }
            if (researchProjects != null){
                for (int i = 0; i < researchProjects.size(); i++) {
                    researchProjects.get(i).setId(idWorker.nextId());
                    researchProjects.get(i).setParentId(researchProjectsId);
                    researchProjects.get(i).setType(5);
                    this.researchService.insertResearchItem((JSONObject) JSONObject.toJSON(researchProjects.get(i)));
                }
            }
            if (researchTeam != null){
                for (int i = 0; i < researchTeam.size(); i++) {
                    researchTeam.get(i).setId(idWorker.nextId());
                    researchTeam.get(i).setParentId(researchTeamId);
                    researchTeam.get(i).setType(6);
                    this.researchService.insertResearchItem((JSONObject) JSONObject.toJSON(researchTeam.get(i)));
                }
            }
        }


        List<Awards> awardsList = this.awardsService.initInfo(id, 0l);
        if (awardsList.size() != 0) {
            Awards awards = awardsList.get(0);
            List<AwardsItem> academicHonorsList = this.awardsService.initItemInfo(awards.getAcademicHonors(), 1);
            List<AwardsItem> scientificAwardsList = this.awardsService.initItemInfo(awards.getScientificAwards(), 2);
            List<AwardsItem> otherAwardsList = this.awardsService.initItemInfo(awards.getOtherAwards(), 3);
            List<AwardsItem> honoraryTitleList = this.awardsService.initItemInfo(awards.getHonoraryTitle(), 4);
            List<AwardsItem> honorWallList = this.awardsService.initItemInfo(awards.getHonorWall(), 5);

            awards.setId(this.idWorker.nextId());
            Long academicHonorsId = this.idWorker.nextId();
            awards.setAcademicHonors(academicHonorsId);
            Long honoraryTitleId = this.idWorker.nextId();
            awards.setHonoraryTitle(honoraryTitleId);
            Long honorWallId = this.idWorker.nextId();
            awards.setHonorWall(honorWallId);
            Long otherAwardsId = this.idWorker.nextId();
            awards.setOtherAwards(otherAwardsId);
            Long scientificAwardsId = this.idWorker.nextId();
            awards.setScientificAwards(scientificAwardsId);
            awards.setUploadTime(null);
            awards.setVersion(version);
            this.awardsService.insertAwards(awards);

            if (academicHonorsList != null){
                for (int i = 0; i < academicHonorsList.size(); i++) {
                    academicHonorsList.get(i).setId(idWorker.nextId());
                    academicHonorsList.get(i).setParentId(academicHonorsId);
                    academicHonorsList.get(i).setType(1);
                    this.awardsService.insertAwardsItem((JSONObject) JSONObject.toJSON(academicHonorsList.get(i)));
                }
            }
            if (scientificAwardsList != null){
                for (int i = 0; i < scientificAwardsList.size(); i++) {
                    scientificAwardsList.get(i).setId(idWorker.nextId());
                    scientificAwardsList.get(i).setParentId(scientificAwardsId);
                    scientificAwardsList.get(i).setType(2);
                    this.awardsService.insertAwardsItem((JSONObject) JSONObject.toJSON(scientificAwardsList.get(i)));
                }
            }
            if (otherAwardsList != null){
                for (int i = 0; i < otherAwardsList.size(); i++) {
                    otherAwardsList.get(i).setId(idWorker.nextId());
                    otherAwardsList.get(i).setParentId(otherAwardsId);
                    otherAwardsList.get(i).setType(3);
                    this.awardsService.insertAwardsItem((JSONObject) JSONObject.toJSON(otherAwardsList.get(i)));
                }
            }
            if (honoraryTitleList != null){
                for (int i = 0; i < honoraryTitleList.size(); i++) {
                    honoraryTitleList.get(i).setId(idWorker.nextId());
                    honoraryTitleList.get(i).setParentId(honoraryTitleId);
                    honoraryTitleList.get(i).setType(4);
                    this.awardsService.insertAwardsItem((JSONObject) JSONObject.toJSON(honoraryTitleList.get(i)));
                }
            }
            if (honorWallList != null){
                for (int i = 0; i < honorWallList.size(); i++) {
                    honorWallList.get(i).setId(idWorker.nextId());
                    honorWallList.get(i).setParentId(honorWallId);
                    honorWallList.get(i).setType(5);
                    this.awardsService.insertAwardsItem((JSONObject) JSONObject.toJSON(honorWallList.get(i)));
                }
            }
        }
    }

}
