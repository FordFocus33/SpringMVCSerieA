package com.calcio.it.springmvcseriea.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClubController {

    @GetMapping("/clubs")
    public String clubsList(){
        return "clubs-list";
    }
}
