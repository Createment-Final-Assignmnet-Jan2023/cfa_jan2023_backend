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

    public static Pokemon toEntity(PokemonDTO userDTO) {
        return Pokemon.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .types(userDTO.getTypes())
                .imageFront(userDTO.getImageFront())
                .imageBack(userDTO.getImageBack())
                .imageArt(userDTO.getImageArt())
                .baseHealthPoints(userDTO.getBaseHealthPoints())
                .baseNormalAttack(userDTO.getBaseNormalAttack())
                .baseNormalDefense(userDTO.getBaseNormalDefense())
                .baseSpecialAttack(userDTO.getBaseSpecialAttack())
                .baseSpecialDefense(userDTO.getBaseSpecialDefense())
                .baseSpeed(userDTO.getBaseSpeed())
                .build();
    }
}
