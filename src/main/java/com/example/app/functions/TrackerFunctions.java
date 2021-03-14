package com.example.app.functions;

import com.example.app.dto.TrackerDto;
import com.example.app.model.Tracker;

import java.util.function.Function;

public class TrackerFunctions {

        public static final Function<Tracker, TrackerDto> trackerToTrackerDTO = tracker -> new TrackerDto(
                tracker.getId(),
                tracker.getAction(),
                tracker.getLocalDate()

        );

        public static final Function<TrackerDto, Tracker> trackerDtoToTracker = trackerDto -> new Tracker(
                trackerDto.getAction(),
                trackerDto.getLocalDate()
        );

}
