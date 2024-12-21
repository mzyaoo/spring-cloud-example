package cn.mzyao.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Api02Application {

    public static void main(String[] args) {
        SpringApplication.run(Api02Application.class, args);
    }

}
