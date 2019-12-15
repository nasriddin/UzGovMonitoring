package uz.safar.open_data.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OpenDataController {

    @GetMapping("/")
    public String loginPage(){
        return "index";
    }
}
