package com.manager.cfa_jan2023.controller;

import com.manager.cfa_jan2023.service.PokemonService;
import com.manager.cfa_jan2023.service.TeamService;
import com.manager.cfa_jan2023.service.dto.PokemonDTO;
import com.manager.cfa_jan2023.service.dto.TeamDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "team")
@RequiredArgsConstructor
public class TeamController {
    //aka endpoint
    //communicates to outside world
    //data gets pulled in as DTO and converted into 'regular data'
    private final TeamService teamService;

    @GetMapping("{id}")
    public TeamDTO getById(@PathVariable long id) {
        return teamService.getById(id);
    }

    @GetMapping
    public List<TeamDTO> getAllTeams() {
        return teamService.getAllTeams();
    }

}
