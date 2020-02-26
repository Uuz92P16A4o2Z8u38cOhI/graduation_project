package cuit.hyl.graduation.fastdfs.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Bean
    public Queue codeEmailQueue() {
        return new Queue("codeEmail");
    }

    @Bean
    public Queue passwordChangeEmailQueue() {
        return new Queue("passwordChangeEmail");
    }

    @Bean
    DirectExchange directEmailExchange() {
        return new DirectExchange("emailExchange");
    }

    @Bean
    Binding bindingCodeEmail() {
        return BindingBuilder.bind(codeEmailQueue()).to(directEmailExchange()).with("codeEmail");
    }

    @Bean
    Binding bindingPasswordChangeEmail() {
        return BindingBuilder.bind(passwordChangeEmailQueue()).to(directEmailExchange()).with("passwordChangeEmail");
    }

}
