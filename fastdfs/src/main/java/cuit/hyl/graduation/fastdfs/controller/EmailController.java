package cuit.hyl.graduation.fastdfs.controller;

import cuit.hyl.graduation.fastdfs.service.mq.provider.EmailProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api( tags = "邮件发送")
@RestController
@RequestMapping("api/fastdfs/email")
public class EmailController {
    @Autowired
    private EmailProvider emailProvider;

    @ApiOperation("发送验证码邮件")
    @RequestMapping(value = "codeEmail", method = RequestMethod.POST)
    public  void sendCodeEmail(){
        emailProvider.sendCodeEmail();
    }

    @ApiOperation("发送用户密码修改提醒邮件")
    @RequestMapping(value = "passwordChangeEmail", method = RequestMethod.POST)
    public void sendPasswordChangeEmail(){
        emailProvider.sendPasswordChangeEmail();
    }

}