package com.manager.cfa_jan2023.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamDTO {

    private long id;
    private List<PokemonDTO> teamMembers;
}
