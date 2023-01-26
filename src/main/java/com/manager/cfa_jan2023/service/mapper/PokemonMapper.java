package com.manager.cfa_jan2023.service.mapper;

import com.manager.cfa_jan2023.repository.model.Pokemon;
import com.manager.cfa_jan2023.service.dto.PokemonDTO;

public class PokemonMapper {
    public static PokemonDTO toDto(Pokemon entity) {
        return PokemonDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .types(entity.getTypes())
                .imageFront(entity.getImageFront())
                .imageBack(entity.getImageBack())
                .imageArt(entity.getImageArt())
                .baseHealthPoints(entity.getBaseHealthPoints())
                .baseNormalAttack(entity.getBaseNormalAttack())
                .baseNormalDefense(entity.getBaseNormalDefense())
                .baseSpecialAttack(entity.getBaseSpecialAttack())
                .baseSpecialDefense(entity.getBaseSpecialDefense())
                .baseSpeed(entity.getBaseSpeed())
                .build();
    }

    public static Pokemon toEntity(PokemonDTO pokemonDTO) {
        return Pokemon.builder()
                .id(pokemonDTO.getId())
                .name(pokemonDTO.getName())
                .types(pokemonDTO.getTypes())
                .imageFront(pokemonDTO.getImageFront())
                .imageBack(pokemonDTO.getImageBack())
                .imageArt(pokemonDTO.getImageArt())
                .baseHealthPoints(pokemonDTO.getBaseHealthPoints())
                .baseNormalAttack(pokemonDTO.getBaseNormalAttack())
                .baseNormalDefense(pokemonDTO.getBaseNormalDefense())
                .baseSpecialAttack(pokemonDTO.getBaseSpecialAttack())
                .baseSpecialDefense(pokemonDTO.getBaseSpecialDefense())
                .baseSpeed(pokemonDTO.getBaseSpeed())
                .build();
    }
}
