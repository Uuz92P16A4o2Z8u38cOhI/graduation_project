package cuit.hyl.graduation.project_ui.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@FeignClient(value = "fastdfs")
public interface FastDFSService {

    @RequestMapping(value = "api/fastdfs/upload/uploadAvatar", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadAvatar(MultipartFile dropFile);


}
