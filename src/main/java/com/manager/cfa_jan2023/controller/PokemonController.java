package com.manager.cfa_jan2023.controller;

import com.manager.cfa_jan2023.service.PokemonService;
import com.manager.cfa_jan2023.repository.model.Pokemon;
import com.manager.cfa_jan2023.service.dto.PokemonDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "pokemon")
@RequiredArgsConstructor
public class PokemonController {
    //aka endpoint
    //communicates to outside world
    //data gets pulled in as DTO and converted into 'regular data'
    private final PokemonService pokemonService;

    @GetMapping("{id}")
    public PokemonDTO getById(@PathVariable long id) {
        return pokemonService.getById(id);
    }

    @GetMapping
    public List<PokemonDTO> getAllPokemons() {
        return pokemonService.getAllPokemons();
    }
}
