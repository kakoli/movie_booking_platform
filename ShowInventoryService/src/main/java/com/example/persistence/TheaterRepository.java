package com.example.persistence;

import com.example.persistence.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer> {

    @Query("SELECT t FROM Theater t WHERE t.name = ?1")
    public Optional<Theater> findTheaterByName(String name);

}
