package com.example.app.service;

import com.example.app.dto.TrainerDto;
import com.example.app.error.TrainerNotFoundException;
import com.example.app.model.Trainer;
import com.example.app.repository.TrainerRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.example.app.functions.TrainerFunctions.trainerDTOtoTrainer;
import static com.example.app.functions.TrainerFunctions.trainerToTrainerDTO;

@Data
@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    @Transactional
    public TrainerDto saveTrainer(TrainerDto trainerDto) {
        Trainer trainer = trainerDTOtoTrainer.apply(trainerDto);
        return trainerToTrainerDTO.apply(trainerRepository.save(trainer));
    }

    @Transactional
    public TrainerDto findById(UUID id) throws TrainerNotFoundException {
        return trainerRepository.findById(id).map(trainerToTrainerDTO).orElseThrow(TrainerNotFoundException::new);
    }

    @Transactional
    public TrainerDto editTrainer(UUID id, TrainerDto trainerDto) throws TrainerNotFoundException {

        return trainerRepository.findById(id)
                .map(trainer -> {
                    trainer.setFirstName(trainerDto.getFirstName());
                    trainer.setLastName(trainerDto.getLastName());
                    trainer.setEmail(trainerDto.getEmail());
                    trainer.setPhoneNumber(trainerDto.getPhoneNumber());
                    return trainerRepository.save(trainer);
                })
                .map(trainerToTrainerDTO)
                .orElseThrow(TrainerNotFoundException::new);
    }

    @Transactional
    public void deleteTrainer(UUID id) throws TrainerNotFoundException {

        Trainer trainer = trainerRepository.findById(id).orElseThrow(TrainerNotFoundException::new);
        trainerRepository.delete(trainer);
    }

    @Transactional
    public List<TrainerDto> findAll() {
        return trainerRepository.findAll().stream().map(trainerToTrainerDTO).collect(Collectors.toList());
    }
}
