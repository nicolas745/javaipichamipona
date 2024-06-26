package com.example.demo.Repository;

import com.example.demo.model.day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface dayRep extends JpaRepository<day,Long> {
    @Override
    List<day> findAll();
    day save(day day);
    void delete(day day);

}
