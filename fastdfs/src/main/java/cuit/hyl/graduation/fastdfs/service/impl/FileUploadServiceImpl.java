package cuit.hyl.graduation.fastdfs.service.impl;

import cuit.hyl.graduation.fastdfs.dao.FileUploadDao;
import cuit.hyl.graduation.fastdfs.service.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * (FileUpload)表服务实现类
 *
 * @author makejava
 * @since 2020-04-20 15:44:28
 */
@Service("fileUploadService")
public class FileUploadServiceImpl implements FileUploadService {
    @Resource
    private FileUploadDao fileUploadDao;

    /**
     * 新增数据
     */
    @Transactional
    @Override
    public int insert(Long id,String fileName, String filePath) {
        return this.fileUploadDao.insert(id, fileName, filePath);
    }

}