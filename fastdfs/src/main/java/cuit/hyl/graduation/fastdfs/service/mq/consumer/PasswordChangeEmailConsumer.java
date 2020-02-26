package cuit.hyl.graduation.fastdfs.service.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.util.Map;

@Component
@RabbitListener(queues = "passwordChangeEmail")
public class PasswordChangeEmailConsumer {
    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @RabbitHandler
    public void sendPasswordChangeEmail(Map msgMap) {
        // 发送 HTML 模板邮件
        Context context = new Context();
        context.setVariable("username", msgMap.get("username"));
        String emailTemplate = templateEngine.process("passwordChangeEmail", context);
        sendTemplatePasswordEmail("密码修改提醒", emailTemplate, msgMap.get("email").toString());
    }

    @Async
    public void sendTemplatePasswordEmail(String subject, String body, String to) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(applicationContext.getEnvironment().getProperty("spring.mail.username"));
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);
            javaMailSender.send(message);
        } catch (Exception e) {

        }
    }
}
