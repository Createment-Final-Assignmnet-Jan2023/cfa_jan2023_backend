package com.manager.cfa_jan2023.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="pokemons")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {
    @Id
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
