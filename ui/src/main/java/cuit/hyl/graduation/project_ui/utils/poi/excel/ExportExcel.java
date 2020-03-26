package cuit.hyl.graduation.project_ui.utils.poi.excel;

import cuit.hyl.graduation.project_ui.annotation.ExcelAttributes;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ExportExcel<T> {

    /**
     * 定制化模板导出
     * @param param
     * @throws IOException
     */
    public void exportByXSSF(Map<String, Object> param) throws IOException, IllegalAccessException {
        List<T> list = (List<T>) param.get("list");
        String path = (String) param.get("path");
        Integer rowStartIndex = (Integer) param.get("rowStartIndex");
        HttpServletResponse response = (HttpServletResponse) param.get("response");
        String fileName = (String) param.get("fileName");

//        SXSSFWorkbook workbook = new SXSSFWorkbook();
        XSSFWorkbook workbook = new XSSFWorkbook(Objects.requireNonNull(ExportExcel.class.getClassLoader().getResourceAsStream(path)));
        Sheet sheet = workbook.getSheetAt(0);
        Row rowModel = sheet.getRow(rowStartIndex);
        CellStyle[] cellStyles = new CellStyle[rowModel.getLastCellNum()];
        for (int i = 0; i < cellStyles.length; i++){
            cellStyles[i] = rowModel.getCell(i).getCellStyle();
        }

        for (int i = 0; i < list.size(); i++) {
            Row row = sheet.createRow(i + rowStartIndex);
            T obj = list.get(i);
            Class clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();

            for (int j = 0; j < cellStyles.length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellStyle(cellStyles[j]);

                for(Field field : fields){
                    ExcelAttributes attributes = field.getAnnotation(ExcelAttributes.class);
                    if (attributes != null){
                        int exportSort = attributes.exportSort();
                        if (exportSort == j){
                            field.setAccessible(true);
                            if (field.get(obj) != null)
                                cell.setCellValue(field.get(obj).toString());
                            break;
                        }
                    }
                }
            }
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        response.setHeader("fileName", URLEncoder.encode(fileName, "UTF-8"));
        workbook.write(response.getOutputStream());

    }

    /**
     * 大文件导出
     */
    public void exportBySXSSF(){

    }

}