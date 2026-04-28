package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class FitnessController {

    @Autowired
    private FitnessRepository fitnessRepo;

    // ✅ Save workout
    @PostMapping("/fitness")
    public String saveWorkout(@RequestBody Fitness fitness) {
        fitnessRepo.save(fitness);
        return "Workout saved";
    }

    // ✅ Get all workouts
    @GetMapping("/fitness")
    public List<Fitness> getWorkouts() {
        return fitnessRepo.findAll();
    }
}