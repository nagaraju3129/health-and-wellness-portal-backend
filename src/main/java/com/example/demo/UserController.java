package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository repo;

    // ✅ ADD THIS (for metrics)
    @Autowired
    private FitnessRepository fitnessRepo;

    // ✅ REGISTER (with duplicate check)
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {

        User existingUser = repo.findByEmail(user.getEmail());

        if (existingUser != null) {
            return "Email already exists";   // ❌ duplicate
        }

        // ✅ DEFAULT ROLE
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER");
        }

        repo.save(user);
        return "Registered successfully";   // ✅ success
    }

    // ✅ GET ALL USERS (Admin panel)
    @GetMapping("/users")
    public List<User> getUsers() {
        return repo.findAll();
    }

    // ✅ LOGIN (FIXED 🔥)
    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {

        User existingUser = repo.findByEmail(user.getEmail());

        if (existingUser != null &&
            existingUser.getPassword().equals(user.getPassword())) {

            return existingUser; // ✅ success
        }

        return null; // ❌ invalid login
    }

    // ❌ DELETE USER (ADMIN FEATURE 🔥)
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        repo.deleteById(id);
        return "User deleted";
    }

    // ✅ METRICS API (NEW 🔥)
    @GetMapping("/metrics")
    public List<Map<String, Object>> getMetrics() {

        List<Map<String, Object>> data = new ArrayList<>();

        data.add(Map.of("name", "Users", "value", repo.count()));
        data.add(Map.of("name", "Workouts", "value", fitnessRepo.count()));

        return data;
    }
}