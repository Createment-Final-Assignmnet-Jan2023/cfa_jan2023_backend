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
public class PokemonDTO {
    private long id;
    private String name;
    private List<String> types;
    private String imageFront;
    private String imageBack;
    private String imageArt;
    private Integer baseHealthPoints;
    private Integer baseNormalAttack;
    private Integer baseNormalDefense;
    private Integer baseSpecialAttack;
    private Integer baseSpecialDefense;
    private Integer baseSpeed;
}
