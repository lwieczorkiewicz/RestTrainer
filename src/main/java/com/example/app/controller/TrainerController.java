package com.example.app.controller;

import com.example.app.dto.TrainerDto;
import com.example.app.error.TrainerNotFoundException;
import com.example.app.service.TrainerService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Data
@RestController
@RequestMapping("/restTrainers")
public class TrainerController {

    private final TrainerService trainerService;

//    @PostMapping
//    public TrainerDto saveTrainer(){
//        return trainerService.saveTrainer(trainerDto);
//    }

    @GetMapping("/{id}")
    public TrainerDto findById(@PathVariable UUID id) throws TrainerNotFoundException{

        return trainerService.findById(id);
    }

    @PutMapping("/{id}")
    public TrainerDto editTrainer(@PathVariable UUID id, @RequestBody TrainerDto trainerDto) throws TrainerNotFoundException {
        return trainerService.editTrainer(id, trainerDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) throws TrainerNotFoundException {
        trainerService.deleteTrainer(id);
    }

    @GetMapping
    public List<TrainerDto> findAll() {
        return trainerService.findAll();
    }
}

