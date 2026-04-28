package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/resources")
@CrossOrigin(origins = "http://localhost:3000")
public class ResourceController {

    @Autowired
    private ResourceRepository repo;

    // ✅ GET ALL
    @GetMapping
    public List<Resource> getAllResources() {
        return repo.findAll();
    }

    // ✅ ADD RESOURCE
    @PostMapping
    public Resource addResource(@RequestBody Resource resource) {
        return repo.save(resource);
    }
    @DeleteMapping("/{id}")
public String delete(@PathVariable Long id) {
    repo.deleteById(id);
    return "Deleted";
}
}