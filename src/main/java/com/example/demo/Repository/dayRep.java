package com.example.demo.Repository;

import com.example.demo.model.day;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface dayRep extends CrudRepository<day,Long> {
    @Override
    List<day> findAll();
}
