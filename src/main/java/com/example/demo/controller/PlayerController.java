package com.example.demo.controller;

import com.example.demo.entity.Player;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@CrossOrigin(origins = "*")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        return playerService.savePlayer(player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Integer id) {
        playerService.deletePlayer(id);
    }

    @GetMapping("/search")
    public List<Player> searchPlayer(@RequestParam String name) {
        return playerService.searchByName(name);
    }

    @GetMapping("/top10")
    public List<Player> getTop10() {
        return playerService.getTop10Players();
    }
}
