package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Fitness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String activity;
    private int duration;

    // Getters & Setters
    public Long getId() { return id; }

    public String getActivity() { return activity; }
    public void setActivity(String activity) { this.activity = activity; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
}