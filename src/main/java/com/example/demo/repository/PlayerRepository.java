package com.example.demo.repository;

import com.example.demo.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

    // Tìm kiếm theo tên gần đúng, không phân biệt hoa thường
    List<Player> findByPlayerNameContainingIgnoreCase(String name);

    // Lấy top 10 theo high score giảm dần
    @Query("SELECT p FROM Player p ORDER BY p.highScore DESC")
    List<Player> findTop10ByHighScore();
}
