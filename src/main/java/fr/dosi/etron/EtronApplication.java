package fr.dosi.etron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@Configuration @EnableAutoConfiguration @ComponentScan
public class EtronApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtronApplication.class, args);
    }

}
