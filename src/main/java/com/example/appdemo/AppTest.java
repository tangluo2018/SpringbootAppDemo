package com.example.appdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class AppTest {

    @RequestMapping("/home")
    public String index(Model module){
        module.addAttribute("message", "Hello Thymeleaf");
        module.addAttribute("items", Arrays.asList("item1", "item2", "item3"));
        return "start_page";
    }
}
