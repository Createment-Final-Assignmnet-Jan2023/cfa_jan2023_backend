package com.manager.cfa_jan2023.repository.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
@Data
@Builder
@AllArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "pokemons_teams",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "pokemon_id"),
            foreignKey = @ForeignKey(name ="fk_team"),
            inverseForeignKey = @ForeignKey(name = "fk_pokemon"))
    private List<Pokemon> teamMembers;
    @ManyToOne
    @JoinColumn(
            name="battle",
            foreignKey = @ForeignKey(name ="fk_battle"),
            nullable=false)
    private Battle battle;

    public Team(List<Pokemon> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public Team() {
        this.teamMembers = new ArrayList<>();
    }

    public void addMember(Pokemon pokemon) {
        this.teamMembers.add(pokemon);
    }

}
