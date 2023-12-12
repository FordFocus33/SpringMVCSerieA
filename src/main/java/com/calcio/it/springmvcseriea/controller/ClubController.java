package com.calcio.it.springmvcseriea.controller;


import com.calcio.it.springmvcseriea.dto.ClubDto;
import com.calcio.it.springmvcseriea.entity.Club;
import com.calcio.it.springmvcseriea.entity.UserEntity;
import com.calcio.it.springmvcseriea.security.SecurityUtil;
import com.calcio.it.springmvcseriea.service.ClubService;
import com.calcio.it.springmvcseriea.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClubController {

    // 500 ошибка 11 видео пересмотреть конец где то с 9 минуты

    private ClubService clubService;
    private UserService userService;

    @Autowired
    public ClubController(ClubService clubService, UserService userService) {
        this.clubService = clubService;
        this.userService = userService;
    }

    @GetMapping("/clubs")
    public String listClubs(Model model){
        UserEntity user = new UserEntity();
        List<ClubDto> clubs = clubService.findAllClubs();
        String userEmail = SecurityUtil.getSessionUser();
        if (userEmail != null){
            user = userService.findByEmail(userEmail);
            model.addAttribute("user", user);
        }else {
            model.addAttribute("user", user);
        }
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    @GetMapping("/clubs/new")
    public String createClubForm(Model model){
        Club club = new Club();
        model.addAttribute("club", club);

        return "clubs-create";
    }

    @PostMapping("/clubs/new")
    public String saveClub(@Valid @ModelAttribute("club") ClubDto clubDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("club", clubDto);
            return "clubs-create";
        }
        clubService.saveClub(clubDto);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/{clubId}/edit")
    public String editClubForm(@PathVariable("clubId") Long id, Model model){
        ClubDto clubDto = clubService.findClubById(id);
        model.addAttribute("club", clubDto);

        return "clubs-edit";
    }

    @PostMapping("/clubs/{clubId}/edit")
    public String updateClub(@PathVariable("clubId") Long id,
                             @Valid @ModelAttribute("club") ClubDto clubDto,
                             BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("club", clubDto);
            return "clubs-edit";
        }
        clubDto.setId(id);
        clubService.updateClub(clubDto);

        return "redirect:/clubs";
    }

    @GetMapping("/clubs/{clubId}")
    public String clubDetail(@PathVariable("clubId") Long id, Model model){
        UserEntity user = new UserEntity();
        ClubDto clubDto = clubService.findClubById(id);
        String userEmail = SecurityUtil.getSessionUser();
        if (userEmail != null){
            user = userService.findByEmail(userEmail);
            model.addAttribute("user", user);
        }else {
            model.addAttribute("user", user);
        }
        model.addAttribute("club", clubDto);

        return "clubs-detail";
    }

    @GetMapping("/clubs/{clubId}/delete")
    public String deleteClub(@PathVariable("clubId") Long id){
        clubService.deleteClub(id);

        return "redirect:/clubs";
    }

    @GetMapping("/clubs/search")
    public String searchClub(@RequestParam(value = "query") String query, Model model){
        List<ClubDto> clubDtos = clubService.searchClubs(query);
        model.addAttribute("clubs", clubDtos);
        return "clubs-list";
    }
}
