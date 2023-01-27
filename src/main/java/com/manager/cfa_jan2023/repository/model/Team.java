package com.manager.cfa_jan2023.repository.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="teams")
@Data
@Builder
@AllArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Pokemon> teamMembers;
    private Long battleId;

    public Team(List<Pokemon> teamMembers){
        this.teamMembers = teamMembers;
    }

    public Team(){
        this.teamMembers = new ArrayList<>();
    }
    public void addMember(Pokemon pokemon){
        this.teamMembers.add(pokemon);
    }

}
