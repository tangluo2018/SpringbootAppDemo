package com.example.appdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppDemoApplication {

    public static void main(String[] args) {
        /*查看ClassLoder, 命令行执行java -jar AppDemo.jar*/
        System.out.println("Main class loader: " + AppDemoApplication.class.getClassLoader());
        System.out.println("TCCL: " + Thread.currentThread().getContextClassLoader());
        SpringApplication.run(AppDemoApplication.class, args);
    }

}
