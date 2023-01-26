package com.manager.cfa_jan2023.service;

import com.manager.cfa_jan2023.controller.error.NotFoundException;
import com.manager.cfa_jan2023.repository.TeamRepository;
import com.manager.cfa_jan2023.repository.model.Team;
import com.manager.cfa_jan2023.service.dto.TeamDTO;
import com.manager.cfa_jan2023.service.mapper.TeamMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class TeamService {
    //business logic happens here
    private final TeamRepository teamRepository;
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

//    public Team generateARandomTeam(int teamSize) {
//        Team team = new Team();
//        while (team.getTeamMembers().size() < teamSize) {
//            pokemonRepository.findById((long) (random.nextInt(151) + 1)).ifPresent(team::addMember);
//        }
//        return team;
//    }
}
