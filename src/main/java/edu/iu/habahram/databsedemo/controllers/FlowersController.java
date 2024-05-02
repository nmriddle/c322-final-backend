package edu.iu.habahram.databsedemo.controllers;

import edu.iu.habahram.databsedemo.model.Flower;
import edu.iu.habahram.databsedemo.repository.FlowersFileRepository;
import edu.iu.habahram.databsedemo.repository.FlowersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/flowers")
public class FlowersController {
    FlowersFileRepository flowersFileRepository;
    FlowersRepository flowersRepository;

    public FlowersController(FlowersFileRepository flowersFileRepository, FlowersRepository flowersRepository) {
        this.flowersFileRepository = flowersFileRepository;
        this.flowersRepository = flowersRepository;
    }

    @PostMapping
    public int add(@RequestBody Flower flower) {
        Flower saved = flowersRepository.save(flower);
        return saved.getId();
    }

    @GetMapping
    public Iterable<Flower> findAll() {
        Iterable<Flower> flowers = flowersRepository.findAll();
        return flowers;
    }

    @GetMapping("/{id}")
    public Flower get(@PathVariable int id) {
        Optional<Flower> flowerOptional = flowersRepository.findById(id);
        // Check if the flower exists
        if (flowerOptional.isPresent()) {
            return flowerOptional.get(); // Return the flower if found
        } else {
            // Handle case when flower with given ID is not found
            // For example, you can return a 404 Not Found response
            return null;
        }
    }

//    @GetMapping
//    public Iterable<Flower> findAllSorted(@RequestParam(required = false, defaultValue = "false") boolean lowToHigh) {
//        return lowToHigh ? flowersRepository.findAllByOrderByCostAsc() : flowersRepository.findAllByOrderByCostDesc();
//    }

    @PostMapping("/search/{lowToHigh}")
    public Iterable<Flower> search(@RequestBody Flower flower, @PathVariable boolean lowToHigh) {
        Iterable<Flower> flowers = lowToHigh ? flowersRepository.findAllByOrderByCostAsc() : flowersRepository.findAllByOrderByCostDesc();
        return flowersFileRepository.search(flowers, flower);
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<?> getImage(@PathVariable int id) {
        try {
            byte[] image = flowersFileRepository.getImage(id);
            return ResponseEntity.status(HttpStatus.FOUND).contentType(MediaType.IMAGE_PNG).body(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/{id}/image")
    public boolean updateImage(@PathVariable int id, @RequestParam MultipartFile file) {
        try {
            return flowersFileRepository.updateImage(id, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
