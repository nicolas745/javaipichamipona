package com.example.demo.Repository;

import com.example.demo.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface userRep extends JpaRepository<user,Long> {
    @Override
    List<user> findAll();
    Optional<user> findById(Long id);
    Optional<user> findByEmail(String email);

    user save(user user);
    void deleteById(Long id);
}