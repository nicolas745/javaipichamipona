package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Game;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface gameRep extends JpaRepository<Game,Long> {
    @Override
    List<Game> findAll();
    void deleteById(Long id);

}
