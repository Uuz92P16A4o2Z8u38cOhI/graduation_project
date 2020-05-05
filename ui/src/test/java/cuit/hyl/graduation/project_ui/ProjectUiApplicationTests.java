package cuit.hyl.graduation.project_ui;

import com.alibaba.fastjson.JSONObject;
import cuit.hyl.graduation.project_ui.entity.BasicInfo;
import cuit.hyl.graduation.project_ui.entity.Education;
import cuit.hyl.graduation.project_ui.service.BasicInfoService;
import cuit.hyl.graduation.project_ui.service.EducationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ProjectUiApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private BasicInfoService basicInfoService;

    @Resource
    private EducationService educationService;


    @Test
    @Transactional
    public void saveVersion(Long id, Long version){
        List<BasicInfo> basicInfoList = this.basicInfoService.queryByPeopleId(id, 0l);
        if (basicInfoList.size() != 0){
            BasicInfo basicInfo = basicInfoList.get(0);
            basicInfo.setVersion(version);
            this.basicInfoService.insertInitInfo((JSONObject) JSONObject.toJSON(basicInfo));
        }

        List<Education> educationList = this.educationService.queryInitInfo(id,0l);
        if (educationList.size() != 0){
            for (int i = 0; i < educationList.size(); i++) {

            }
            this.educationService.insertForeach(educationList);

        }

    }

}
