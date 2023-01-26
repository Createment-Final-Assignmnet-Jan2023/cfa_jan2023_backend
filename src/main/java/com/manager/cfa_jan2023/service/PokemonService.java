package com.manager.cfa_jan2023.service;

import com.manager.cfa_jan2023.controller.error.NotFoundException;
import com.manager.cfa_jan2023.repository.PokemonRepository;
import com.manager.cfa_jan2023.repository.model.Pokemon;
import com.manager.cfa_jan2023.repository.model.Team;
import com.manager.cfa_jan2023.service.dto.PokemonDTO;
import com.manager.cfa_jan2023.service.mapper.PokemonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PokemonService {
    //business logic happens here
    private final PokemonRepository pokemonRepository;
    Random random = new Random();

    public PokemonDTO getById(long id) {
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found!"));
        return PokemonMapper.toDto(pokemon);
    }

    public List<PokemonDTO> getAllPokemons() {
        return pokemonRepository.findAll().stream()
                .map(PokemonMapper::toDto)
                .toList();
    }

//    public Team generateARandomTeam(int teamSize) {
//        Team team = new Team();
//        while (team.getTeamMembers().size() < teamSize) {
//            pokemonRepository.findById((long) (random.nextInt(151) + 1)).ifPresent(team::addMember);
//        }
//        return team;
//    }
}
