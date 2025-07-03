package com.example.demo.controller;

import com.example.demo.entity.National;
import com.example.demo.entity.Player;
import com.example.demo.service.NationalService;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayerPageController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private NationalService nationalService;

    @GetMapping
    public String showPlayerList(Model model) {
        model.addAttribute("players", playerService.getAllPlayers());
        return "players"; // Tên file HTML
    }

    @PostMapping("/add")
    public String addPlayer(@RequestParam String playerName,
                            @RequestParam Integer highScore,
                            @RequestParam Integer level,
                            @RequestParam Integer nationalId) {

        National national = nationalService.getNationalById(nationalId).orElse(null);
        if (national == null) return "redirect:/players";

        Player player = new Player(playerName, highScore, level, national);
        playerService.savePlayer(player);
        return "redirect:/players";
    }

    @GetMapping("/delete/{id}")
    public String deletePlayer(@PathVariable Integer id) {
        playerService.deletePlayer(id);
        return "redirect:/players";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Player player = playerService.getPlayerById(id).orElse(null);
        List<National> nationalList = nationalService.getAllNationals();

        model.addAttribute("player", player);
        model.addAttribute("nationals", nationalList);
        return "edit-player";
    }

    @PostMapping("/update")
    public String updatePlayer(@ModelAttribute("player") Player player,
                               @RequestParam("nationalId") Integer nationalId) {
        National national = nationalService.getNationalById(nationalId).orElse(null);
        player.setNational(national);
        playerService.savePlayer(player);
        return "redirect:/players";
    }



}
