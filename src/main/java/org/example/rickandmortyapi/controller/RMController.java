package org.example.rickandmortyapi.controller;

import org.example.rickandmortyapi.model.RMCharakter;
import org.example.rickandmortyapi.service.RMService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RMController {
    private final RMService service;

    public RMController(RMService rmService) {
        this.service = rmService;
    }

    @GetMapping("/characters")
    public List<RMCharakter> getCharacters(
            @RequestParam(required = false) String status
    ) {
        if(status == null) {
            return service.getAllCharacters();
        }

        return service.getFilteredCharactersByStatus(status);
    }

    @GetMapping("/characters/{id}")
    public RMCharakter getCharacterByID(@PathVariable String id) {
        return service.getCharacterById(id);
    }

    @GetMapping("/species-statistic")
    public long getSpeciesStatistic(@RequestParam(required = false) String species) {
        return service.getSpeciesStatistic(species);
    }
}
