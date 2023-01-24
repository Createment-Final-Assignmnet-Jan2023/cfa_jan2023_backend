package com.manager.cfa_jan2023.service;

import com.manager.cfa_jan2023.repository.PokemonRepository;
import com.manager.cfa_jan2023.repository.model.Pokemon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
    //business logic happens here
    private final PokemonRepository pokemonRepository;


    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }
    public List<Pokemon> findAllPokemons(){
        List<Pokemon> list = pokemonRepository.findAll();
        return pokemonRepository.findAll();
    }
}
