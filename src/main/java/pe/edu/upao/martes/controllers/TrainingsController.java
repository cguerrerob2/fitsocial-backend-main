package pe.edu.upao.martes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upao.martes.models.Trainings;
import pe.edu.upao.martes.services.TrainingsService;

import java.util.List;

@RestController
@RequestMapping("training")
@CrossOrigin(origins = "http://localhost:4200")
public class TrainingsController {

    @Autowired
    private TrainingsService trainingsService;

    @GetMapping("/")
    public List<Trainings> listTrainings() {
        return trainingsService.listAllTrainings();
    }

    @PostMapping("/")
    public Trainings createTraining(@RequestBody Trainings training) {
        return trainingsService.saveTraining(training);
    }

    @DeleteMapping("/{trainingId}")
    public ResponseEntity<Void> deleteTraining(@PathVariable Long trainingId) {
        try {
            trainingsService.deleteTraining(trainingId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
