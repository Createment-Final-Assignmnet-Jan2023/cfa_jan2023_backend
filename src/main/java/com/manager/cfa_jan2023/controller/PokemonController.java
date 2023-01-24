package com.manager.cfa_jan2023.controller;

import com.manager.cfa_jan2023.service.PokemonService;
import com.manager.cfa_jan2023.repository.model.Pokemon;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "pokemon")
public class PokemonController {
    //aka endpoint
    //communicates to outside world
    //data gets pulled in as DTO and converted into 'regular data'
    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Pokemon> findAllPokemons() {
        return pokemonService.findAllPokemons();
    }
}
