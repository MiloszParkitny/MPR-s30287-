package com.example.fishinglicense.repository;

import com.example.fishinglicense.model.FishingArea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FishingAreaRepository extends JpaRepository<FishingArea, Long> {

    Optional<FishingArea> findByName(String name);
}
