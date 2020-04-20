package cuit.hyl.graduation.fastdfs.service;

import cuit.hyl.graduation.fastdfs.entity.FileUpload;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (FileUpload)表服务接口
 *
 * @author makejava
 * @since 2020-04-20 15:43:14
 */
public interface FileUploadService {

    /**
     * 新增数据
     */
    int insert(Long id,String fileName, String filePath);

}