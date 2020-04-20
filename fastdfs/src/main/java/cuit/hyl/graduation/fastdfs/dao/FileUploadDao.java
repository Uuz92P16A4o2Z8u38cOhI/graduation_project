package cuit.hyl.graduation.fastdfs.dao;


import org.apache.ibatis.annotations.Mapper;

/**
 * (FileUpload)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-20 15:44:27
 */
@Mapper
public interface FileUploadDao {

    /**
     * 新增数据
     * @return 影响行数
     */
    int insert(Long id,String fileName, String filePath);

}