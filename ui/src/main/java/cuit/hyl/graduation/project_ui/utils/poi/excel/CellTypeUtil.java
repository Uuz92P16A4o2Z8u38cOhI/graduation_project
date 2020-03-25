package cuit.hyl.graduation.project_ui.utils.poi.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

public class CellTypeUtil {
    public static Object getValue(Cell cell){
        Object value = null;
        switch (cell.getCellType()){
            case NUMERIC: // 数字
                if (DateUtil.isCellDateFormatted(cell)){
                    value = cell.getDateCellValue();
                }else {
                    value = cell.getNumericCellValue();
                }
                break;
            case STRING: // 字符串
                value = cell.getStringCellValue();
                break;
            case BOOLEAN: // Boolean
                value = cell.getBooleanCellValue();
                break;
            case FORMULA: // 公式
                value = cell.getCellFormula();
                /*try {
                    value = cell.getStringCellValue();
                } catch (IllegalStateException e) {
                    value = String.valueOf(cell.getNumericCellValue());
                }*/
                break;
            case BLANK: // 空值
                value = "";
                break;
            case _NONE: // 故障
                value = "非法字符";
                break;
            default:
                value = "未知类型";
                break;
        }
        return value;
    }
}
