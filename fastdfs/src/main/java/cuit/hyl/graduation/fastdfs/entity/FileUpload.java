package cuit.hyl.graduation.fastdfs.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (FileUpload)实体类
 *
 * @author makejava
 * @since 2020-04-20 15:44:24
 */
public class FileUpload implements Serializable {
    private static final long serialVersionUID = 678580172349651824L;
    
    private Long id;
    /**
    * 文件名
    */
    private String fileName;
    /**
    * 访问路径
    */
    private String filePath;
    /**
    * 上传时间
    */
    private Date uploadTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

}