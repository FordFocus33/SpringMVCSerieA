package com.calcio.it.springmvcseriea.controller;

import com.calcio.it.springmvcseriea.dto.PlayerDto;
import com.calcio.it.springmvcseriea.entity.Player;
import com.calcio.it.springmvcseriea.entity.UserEntity;
import com.calcio.it.springmvcseriea.security.SecurityUtil;
import com.calcio.it.springmvcseriea.service.PlayerService;
import com.calcio.it.springmvcseriea.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PlayerController {

    private PlayerService playerService;
    private UserService userService;

    @Autowired
    public PlayerController(PlayerService playerService, UserService userService) {
        this.playerService = playerService;
        this.userService = userService;
    }

    @GetMapping("/players/{clubId}/new")
    public String createPlayerForm(@PathVariable("clubId") Long id, Model model){
        Player player = new Player();
        model.addAttribute("clubId", id);
        model.addAttribute("player", player);
        return "players-create";
    }

    @PostMapping("/players/{clubId}")
    public String createPlayer(@PathVariable("clubId") Long id, @ModelAttribute("player") PlayerDto playerDto,
                              BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("player", playerDto);
            return "players-create";
        }
        playerService.createPlayer(id, playerDto);
        return "redirect:/clubs/" + id;
    }

    @GetMapping("/players")
    public String playerList(Model model){
        UserEntity user = new UserEntity();
        List<PlayerDto> players = playerService.findAllPlayers();
        String userEmail = SecurityUtil.getSessionUser();
        if (userEmail != null){
            user = userService.findByEmail(userEmail);
            model.addAttribute("user", user);
        }else {
            model.addAttribute("user", user);
        }
        model.addAttribute("players", players);

        return "players-list";
    }

    @GetMapping("/players/{playerId}")
    public String viewPlayer(@PathVariable("playerId") Long id, Model model){
        UserEntity user = new UserEntity();
        PlayerDto playerDto = playerService.findById(id);
        String userEmail = SecurityUtil.getSessionUser();
        if (userEmail != null){
            user = userService.findByEmail(userEmail);
            model.addAttribute("user", user);
        }else {
            model.addAttribute("user", user);
        }
        // model.addAttribute("club", playerDto); Зачем это?! Якобы для того, чтобы скрыть кнопки редактирования. Но все итак работает

        model.addAttribute("player", playerDto);

        return "players-detail";
    }

    @GetMapping("/players/{playerId}/edit")
    public String editPlayerForm(@PathVariable("playerId") Long id, Model model){
        PlayerDto playerDto = playerService.findById(id);
        model.addAttribute("player", playerDto);
        return "players-edit";
    }

    @PostMapping("/players/{playerId}/edit")
    public String updatePlayer(@PathVariable("playerId") Long id,
                              @Valid @ModelAttribute("player") PlayerDto playerDto,
                              BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("player", playerDto);
            return "players-edit";
        }

        playerService.updatePlayer(id, playerDto);
        return "redirect:/players";
    }

    @GetMapping("/players/{playerId}/delete")
    public String deleteplayer(@PathVariable("playerId") Long id){
        playerService.deletePlayer(id);
        return "redirect:/players";
    }
}
