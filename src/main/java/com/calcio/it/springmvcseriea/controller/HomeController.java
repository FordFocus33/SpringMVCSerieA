package com.calcio.it.springmvcseriea.controller;

import com.calcio.it.springmvcseriea.dto.ClubDto;
import com.calcio.it.springmvcseriea.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private ClubService clubService;

    @Autowired
    public HomeController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/")
    public String home(Model model){
        List<ClubDto> clubs = clubService.findAllClubs();
        model.addAttribute("clubs", clubs);

        return "home";
    }
}
