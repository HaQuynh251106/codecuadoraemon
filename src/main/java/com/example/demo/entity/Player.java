package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer playerId;

    @Column(nullable = false)
    private String playerName;

    private Integer highScore;
    private Integer level;

    @ManyToOne
    @JoinColumn(name = "national_id")
    private National national;

    // Constructors
    public Player() {}

    public Player(String playerName, Integer highScore, Integer level, National national) {
        this.playerName = playerName;
        this.highScore = highScore;
        this.level = level;
        this.national = national;
    }

    // Getters and Setters
    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getHighScore() {
        return highScore;
    }

    public void setHighScore(Integer highScore) {
        this.highScore = highScore;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public National getNational() {
        return national;
    }

    public void setNational(National national) {
        this.national = national;
    }
}
