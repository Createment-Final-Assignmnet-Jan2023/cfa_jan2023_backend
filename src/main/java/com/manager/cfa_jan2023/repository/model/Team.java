package com.manager.cfa_jan2023.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.LinkedList;

@Entity
@Table(name="teams")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @Id
    private long id;
    private LinkedList<Pokemon> teamMembers;
    private Long battleId;

    public Team(LinkedList<Pokemon> teamMembers){
        this.teamMembers = teamMembers;
    }
    public void addMember(Pokemon pokemon){
        this.teamMembers.add(pokemon);
    }

}
