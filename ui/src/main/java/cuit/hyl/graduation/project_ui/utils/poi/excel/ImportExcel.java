package cuit.hyl.graduation.project_ui.utils.poi.excel;

import cuit.hyl.graduation.project_ui.annotation.ExcelAttributes;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ImportExcel<T> {

    public List<T> importByXSSF(Map<String, Object> param) throws IOException, IllegalAccessException, InstantiationException {
        InputStream inputStream = (InputStream) param.get("inputStream");
        Class<T> clazz = (Class) param.get("clazz");
        Integer id = (Integer) param.get("id");
        int startIndex = (int) param.get("startIndex");

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        List<T> list = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = startIndex; i <= lastRowNum; i++) {
            Row row = sheet.getRow(i);
            int lastCellNum = row.getLastCellNum();
            T obj = clazz.newInstance();

            for (int j = 0; j < lastCellNum + 1; j++) {
                Cell cell;
                if (j == lastCellNum ){
                    cell = row.createCell(j);
                }
                cell = row.getCell(j);
                Object value = CellTypeUtil.getValue(cell);

                for(Field field : fields){
                    field.setAccessible(true);
                    ExcelAttributes attributes = field.getAnnotation(ExcelAttributes.class);
                    if (attributes != null){
                        int importSort = attributes.importSort();
                        if (importSort == 999){
                            field.set(obj, id);
                        }
                        if(importSort == j){
                            if (value instanceof Double){
                                field.set(obj, ((Double) value).intValue());
                            }else {
                                field.set(obj, value);
                            }
                            break;
                        }
                    }
                }
            }
            list.add(obj);
        }
        return list;
    }
}
