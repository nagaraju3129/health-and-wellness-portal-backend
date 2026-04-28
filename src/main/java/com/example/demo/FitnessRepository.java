package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FitnessRepository extends JpaRepository<Fitness, Long> {
}