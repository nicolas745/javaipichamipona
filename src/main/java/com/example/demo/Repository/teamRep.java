package com.example.demo.Repository;

import com.example.demo.model.team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface teamRep extends JpaRepository<team,Long>
{
    @Override
    List<team> findAll();
    List<team> findTeamsByChampionships_Id(Long championshipId);
    Optional<team> findById(Long id);

}
