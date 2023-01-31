package com.manager.cfa_jan2023.controller;

import com.manager.cfa_jan2023.service.PokemonService;
import com.manager.cfa_jan2023.service.dto.PokemonDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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
    public Page<PokemonDTO> getPokemons(Pageable pageable) {
        return pokemonService.getPokemons(pageable);
    }

}
