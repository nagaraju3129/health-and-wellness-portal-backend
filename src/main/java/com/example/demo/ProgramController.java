package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/programs")
@CrossOrigin(origins = "http://localhost:3000")
public class ProgramController {

    @Autowired
    private ProgramRepository repo;

    // ✅ GET ALL
    @GetMapping
    public List<Program> getAllPrograms() {
        return repo.findAll();
    }

    // ✅ ADD PROGRAM
    @PostMapping
    public Program addProgram(@RequestBody Program program) {
        return repo.save(program);
    }
}