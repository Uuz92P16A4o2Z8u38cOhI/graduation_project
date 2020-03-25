package cuit.hyl.graduation.project_ui.controller;

import cuit.hyl.graduation.project_ui.entity.BasicInfo;
import cuit.hyl.graduation.project_ui.entity.ResponseResult;
import cuit.hyl.graduation.project_ui.service.BasicInfoService;
import cuit.hyl.graduation.project_ui.utils.poi.excel.ExportExcel;
import cuit.hyl.graduation.project_ui.utils.poi.excel.ImportExcel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "Poi操作")
@RestController
@RequestMapping("api/ui/Poi")
public class PoiController {
    @Autowired
    private BasicInfoService basicInfoService;

    @ApiOperation("导出Excel")
    @PostMapping("exportExcel")
    public ResponseResult exportExcel() {

        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功导出");
    }

    @ApiOperation("导出定制化Excel--个人")
    @PostMapping("exportModelExcel/{id}")
    public void exportModelExcel(@PathVariable Integer id,HttpServletResponse response) {
        List<BasicInfo> list = basicInfoService.queryByPeopleId(id);
        ExportExcel<BasicInfo> exportExcel = new ExportExcel<>();
        Map<String, Object> param = new HashMap<>();
        param.put("list", list);
        param.put("path","static/excel/BasicInfo.xlsx");
        param.put("rowStartIndex", 1);
        param.put("response", response);
        param.put("fileName","基础信息.xlsx");

        try {
            exportExcel.exportByXSSF(param);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


//        return new ResponseResult(ResponseResult.CodeStatus.OK,"成功导出");
    }

    @ApiOperation("导入Excel")
    @PostMapping("importExcel/{type}/{id}")
    public ResponseResult importExcel(@PathVariable String type,@PathVariable Integer id, MultipartFile multipartFile) {
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
