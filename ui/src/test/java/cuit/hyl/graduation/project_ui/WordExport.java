package cuit.hyl.graduation.project_ui;

import cn.afterturn.easypoi.entity.ImageEntity;
import cn.afterturn.easypoi.word.WordExportUtil;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
}
