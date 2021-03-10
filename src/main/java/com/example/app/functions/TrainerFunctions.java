package com.example.app.functions;

import com.example.app.dto.TrainerDto;
import com.example.app.model.Trainer;

import java.util.ArrayList;
import java.util.function.Function;

public class TrainerFunctions {

    public static final Function<Trainer, TrainerDto> trainerToTrainerDTO = trainer -> new TrainerDto(
            trainer.getId(),
            trainer.getFirstName(),
            trainer.getLastName(),
            trainer.getEmail(),
            trainer.getPhoneNumber(),
            "ddd",
            new ArrayList()
    );

    public static final Function<TrainerDto, Trainer> trainerDTOtoTrainer = trainerDTO -> new Trainer(
            trainerDTO.getId(),
            trainerDTO.getFirstName(),
            trainerDTO.getLastName(),
            trainerDTO.getEmail(),
            trainerDTO.getPhoneNumber()
    );
}

