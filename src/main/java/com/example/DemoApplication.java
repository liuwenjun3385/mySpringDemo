package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@MapperScan("com.example.mapper")
@SpringBootApplication
@ComponentScan(basePackages= {"com.example.*"})
public class DemoApplication implements CommandLineRunner {

  @Value("${server.port:8089}")
  private  String port;

    public static void main(String[] args) {
        //SpringApplication.run(DemoApplication.class, args);
        SpringApplication app = new SpringApplication(DemoApplication.class);
        app.run(args);
        app.setBannerMode(Banner.Mode.OFF);

        System.out.println("1111111111111");
    }

    @Override
    public void run(String... strings) throws Exception {

        System.out.println(String.format("Application is success, Index >> http://127.0.0.1:{}", port));
        System.out.println(String.format("Swagger Url "+port+" >> http://127.0.0.1:9090/demo/swagger-ui.html",  port));
    }
}
