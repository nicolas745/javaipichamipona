package com.example.demo.Repository;

import com.example.demo.model.ChampionShip;
import com.example.demo.struc.ChampionShipstruc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChampionShipRep extends JpaRepository<ChampionShip, Long> {
    @Override
    List<ChampionShip> findAll();

    Optional<ChampionShip> findById(long id);

    ChampionShip save(ChampionShip championShip);

    void deleteById(Long id);
}