package cuit.hyl.graduation.project_ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProjectUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectUiApplication.class, args);
    }

}
