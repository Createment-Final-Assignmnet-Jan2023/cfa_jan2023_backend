package com.manager.cfa_jan2023.service.mapper;

import com.manager.cfa_jan2023.repository.model.Pokemon;
import com.manager.cfa_jan2023.service.dto.PokemonDTO;

public class PokemonMapper {
    public static PokemonDTO toDto(Pokemon entity) {
        //todo: fill out rest of fields
        return PokemonDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static Pokemon toEntity(PokemonDTO userDTO) {
        //todo: fill out rest of fields
        return Pokemon.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .build();
    }
}
