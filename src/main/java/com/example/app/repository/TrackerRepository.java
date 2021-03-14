package com.example.app.repository;

import com.example.app.model.Tracker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrackerRepository extends JpaRepository<Tracker, UUID> {
}
