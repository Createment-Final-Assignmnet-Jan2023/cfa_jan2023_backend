package com.manager.cfa_jan2023.repository.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "battles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Battle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy="battle")
    private List<Team> teams;
//    @ManyToOne
//    @JoinColumn(name = "player_team_id")
//    private Long playerTeamId;
//    @ManyToOne
//    @JoinColumn(name = "opponent_team_id")
//    private Long opponentTeamId;
//    private Long winningTeamId;
//    private int roundNumber;
}
