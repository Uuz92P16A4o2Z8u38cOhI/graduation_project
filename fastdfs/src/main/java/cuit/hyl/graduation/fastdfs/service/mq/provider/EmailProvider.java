package cuit.hyl.graduation.fastdfs.service.mq.provider;

import cuit.hyl.graduation.fastdfs.utils.RedisUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class EmailProvider {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 发送验证码邮件
     */
    @Async
    public void sendCodeEmail(String email) {
        Map<String,Object> msgMap=new HashMap<>();

        String code = getCode();

        msgMap.put("username","用户");
        msgMap.put("code", code);
        msgMap.put("email", email);
        msgMap.put("time", LocalDateTime.now());

        redisUtils.set(email, code, 180L);

        amqpTemplate.convertAndSend("emailExchange","codeEmail",msgMap);
    }

    /**
     * 发送密码修改成功邮件
     */
    @Async
    public void sendPasswordChangeEmail(){
        Map<String,Object> msgMap=new HashMap<>();
        msgMap.put("username","用户");
        msgMap.put("code",getCode());
        msgMap.put("email", "2963487848@qq.com");
        msgMap.put("time", LocalDateTime.now());
        amqpTemplate.convertAndSend("emailExchange","passwordChangeEmail",msgMap);
    }

    public String getCode() {
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder code=new StringBuilder(6);
        for(int i = 0; i < 6; i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            code.append(ch);
        }
        return code.toString();
    }

}
