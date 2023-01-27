package com.manager.cfa_jan2023.service;

import com.manager.cfa_jan2023.controller.error.NotFoundException;
import com.manager.cfa_jan2023.repository.PokemonRepository;
import com.manager.cfa_jan2023.repository.TeamRepository;
import com.manager.cfa_jan2023.repository.model.Team;
import com.manager.cfa_jan2023.service.dto.TeamDTO;
import com.manager.cfa_jan2023.service.mapper.TeamMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

import static com.manager.cfa_jan2023.service.mapper.TeamMapper.toEntity;

@Service
@RequiredArgsConstructor
public class TeamService {
    //business logic happens here
    private final TeamRepository teamRepository;
    private final PokemonRepository pokemonRepository;
    Random random = new Random();

    public TeamDTO getById(long id) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found!"));
        return TeamMapper.toDto(team);
    }

    public List<TeamDTO> getAllTeams() {
        return teamRepository.findAll().stream()
                .map(TeamMapper::toDto)
                .toList();
    }

        public TeamDTO generateARandomTeam(int teamSize) {
        Team team = new Team();
            for (int i = 0; i < teamSize; i++) {
            pokemonRepository.findById((long) (random.nextInt(151) + 1)).ifPresent(team::addMember);
        }

        return createTeam(TeamMapper.toDto(team));
    }
    public TeamDTO createTeam(TeamDTO teamDTO) {
        Team savedTeam = teamRepository.save(toEntity(teamDTO));
        return TeamMapper.toDto(savedTeam);
    }
}
