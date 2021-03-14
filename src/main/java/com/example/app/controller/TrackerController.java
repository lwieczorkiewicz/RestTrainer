package com.example.app.controller;

import com.example.app.dto.TrackerDto;
import com.example.app.service.TrackerService;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/restTrainers")
public class TrackerController {

    private final TrackerService trackerService;

    @PostMapping
    public TrackerDto saveTrainer(@RequestBody TrackerDto trackerDto){
        return trackerService.saveTracker(trackerDto);
    }

}

