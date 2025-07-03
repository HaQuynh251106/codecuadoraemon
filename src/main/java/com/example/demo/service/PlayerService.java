package com.example.demo.service;

import com.example.demo.entity.Player;
import com.example.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public void deletePlayer(Integer id) {
        playerRepository.deleteById(id);
    }

    public Optional<Player> getPlayerById(Integer id) {
        return playerRepository.findById(id);
    }

    public List<Player> searchByName(String name) {
        return playerRepository.findByPlayerNameContainingIgnoreCase(name);
    }

    public List<Player> getTop10Players() {
        return playerRepository.findTop10ByHighScore();
    }
}
