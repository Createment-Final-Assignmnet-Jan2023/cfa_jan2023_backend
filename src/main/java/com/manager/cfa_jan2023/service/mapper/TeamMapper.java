package com.manager.cfa_jan2023.service.mapper;

import com.manager.cfa_jan2023.repository.model.Pokemon;
import com.manager.cfa_jan2023.repository.model.Team;
import com.manager.cfa_jan2023.service.dto.PokemonDTO;
import com.manager.cfa_jan2023.service.dto.TeamDTO;

public class TeamMapper {
    public static TeamDTO toDto(Team entity) {
        return TeamDTO.builder()
                .id(entity.getId())
                .teamMembers(entity.getTeamMembers())
                .build();
    }

    public static Team toEntity(TeamDTO teamDTO) {
        return Team.builder()
                .id(teamDTO.getId())
                .teamMembers(teamDTO.getTeamMembers())
                .build();
    }
}
