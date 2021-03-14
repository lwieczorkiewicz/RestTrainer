package com.example.app.service;

import com.example.app.dto.TrackerDto;
import com.example.app.error.TrainerNotFoundException;
import com.example.app.model.Tracker;
import com.example.app.repository.TrackerRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.UUID;

import static com.example.app.functions.TrackerFunctions.trackerDtoToTracker;
import static com.example.app.functions.TrackerFunctions.trackerToTrackerDTO;

@Data
@Service
public class TrackerService {

    private final TrackerRepository trackerRepository;

    @Transactional
    public TrackerDto saveTracker(TrackerDto trackerDto){

        Tracker tracker = trackerDtoToTracker.apply(trackerDto);
        return trackerToTrackerDTO.apply(trackerRepository.save(tracker));
    }
}
