package cuit.hyl.graduation.project_ui;

import cn.afterturn.easypoi.entity.ImageEntity;
import cn.afterturn.easypoi.word.WordExportUtil;
import cuit.hyl.graduation.project_ui.entity.BasicInfo;
import cuit.hyl.graduation.project_ui.service.BasicInfoService;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class WordExport {

    SimpleDateFormat format = new SimpleDateFormat();

    /**

     * 简单导出包含图片

     */
    @Test
    public void imageWordExport() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("department", "Easypoi");
        map.put("person", "JueYue");
        map.put("time", format.format(new Date()));
        ImageEntity image = new ImageEntity();
        image.setHeight(200);
        image.setWidth(500);
        image.setUrl("http://192.168.91.128:8888/group1/M00/00/00/wKhbgl5OSHmAHkKeAAHDlRZ75TY816.jpg");
        image.setType(ImageEntity.URL);
        map.put("testCode", image);
        try {
            XWPFDocument doc = WordExportUtil.exportWord07(
                    "C:\\Users\\25466\\Desktop\\test.docx", map);
            FileOutputStream fos = new FileOutputStream("C:\\Users\\25466\\Desktop\\image.docx");
            doc.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**

     * 简单导出没有图片和Excel

     */
    @Test
    public void SimpleWordExport() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("department", "Easypoi");
        map.put("person", "JueYue");
        map.put("time", format.format(new Date()));
        map.put("me","JueYue");
        map.put("date", "2015-01-03");
        try {
            XWPFDocument doc = WordExportUtil.exportWord07(
                    "C:\\Users\\25466\\Desktop\\test.docx", map);
            FileOutputStream fos = new FileOutputStream("C:\\Users\\25466\\Desktop\\simple.docx");
            doc.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private BasicInfoService basicInfoService;

    @Test
    public void BasicInfoWord(){

        String fastDFSURL = "http://192.168.91.128:8888/";
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");

        Map<String, Object> map = new HashMap<String, Object>();
        List<BasicInfo> basicInfoList = basicInfoService.queryByPeopleId(1l, 0l);
        BasicInfo basicInfo = basicInfoList.get(0);
        if (basicInfo != null){
            map.put("name", basicInfo.getName());
            map.put("birthday", sdf.format(basicInfo.getBirthday()));
            map.put("sex", basicInfo.getSex() == 0?"女":"男");
            map.put("age", basicInfo.getAge());
            map.put("politicalStatus", basicInfo.getPoliticalStatus());
            map.put("hometown", basicInfo.getHometown());
            map.put("schoolName", basicInfo.getSchoolId());
            map.put("department", basicInfo.getDepartment());
            map.put("degree", basicInfo.getDegree());
            map.put("position", basicInfo.getPosition());
            map.put("jobTitle", basicInfo.getJobTitle());
            map.put("subject", basicInfo.getSubject());
            map.put("phone", basicInfo.getPhone());
            map.put("email", basicInfo.getEmail());
            map.put("fax", basicInfo.getFax());
            map.put("address", basicInfo.getAddress());
            map.put("introduction", basicInfo.getIntroduction());
            map.put("researchAreas", basicInfo.getResearchAreas());

            ImageEntity image = new ImageEntity();
            image.setHeight(200);
            image.setWidth(200);
            image.setUrl(fastDFSURL + basicInfo.getAvatatUrl());
            image.setType(ImageEntity.URL);
            map.put("avatar", image);

            try {
                XWPFDocument doc = WordExportUtil.exportWord07(
                        "C:\\Users\\25466\\Desktop\\BasicInfo.docx", map);
                FileOutputStream fos = new FileOutputStream("C:\\Users\\25466\\Desktop\\BasicInfo1.docx");
                doc.write(fos);
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
