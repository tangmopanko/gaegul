package kr.hyeongmeme.gaegulbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
public class GaegulBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(GaegulBotApplication.class, args);
    }

}
