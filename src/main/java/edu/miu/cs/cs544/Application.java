package edu.miu.cs.cs544;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"edu.miu.common", "edu.miu.cs.cs544", "edu.miu.cs.cs544.service", "edu.miu.cs.cs544.repository","edu.miu.cs.cs544.controller"})
@EnableScheduling
@EnableJms
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
    }

}
