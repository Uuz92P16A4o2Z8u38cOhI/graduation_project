package cuit.hyl.graduation.fastdfs.controller;

import cuit.hyl.graduation.fastdfs.entity.FileUpload;
import cuit.hyl.graduation.fastdfs.service.FileUploadService;
import cuit.hyl.graduation.fastdfs.service.StorageService;
import cuit.hyl.graduation.fastdfs.utils.SnowflakeIdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api( tags = "文件上传")
@RestController
@RequestMapping("api/fastdfs/upload")
public class UploadController {
    @Value("${fastdfs.base.url}")
    private String FASTDFS_BASE_URL;

    @Autowired
    private StorageService storageService;

    @Autowired
    private FileUploadService fileUploadService;

    /**
     * 文件上传
     *
     * @param dropFile    Dropzone
     * @param editorFiles wangEditor
     * @return
     */
    @ApiOperation("MultipartFile dropFile, MultipartFile[] editorFiles")
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Map<String, Object> upload(MultipartFile dropFile, MultipartFile[] editorFiles) {
        Map<String, Object> result = new HashMap<>();

        // Dropzone 上传
        if (dropFile != null) {
            result.put("fileName", writeFile(dropFile));
        }

        // wangEditor 上传
        if (editorFiles != null && editorFiles.length > 0) {
            List<String> fileNames = new ArrayList<>();
            for (MultipartFile editorFile : editorFiles) {
                fileNames.add(writeFile(editorFile));
            }
            result.put("filePath", fileNames);
        }

        return result;
    }

    /**
     * 将图片写入指定目录
     *
     * @param multipartFile
     * @return 返回文件完整路径
     */
    public String writeFile(MultipartFile multipartFile) {
        // 获取文件后缀
        String oName = multipartFile.getOriginalFilename();
        String extName = oName.substring(oName.lastIndexOf(".") + 1);

        // 文件存放路径
        String url = null;
        //文件名
        String uploadUrl = null;
        try {
            uploadUrl = storageService.upload(multipartFile.getBytes(), extName);
            url = FASTDFS_BASE_URL + uploadUrl;

            SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1,3);
            int i = fileUploadService.insert(idWorker.nextId(),uploadUrl,url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return uploadUrl;
    }

}