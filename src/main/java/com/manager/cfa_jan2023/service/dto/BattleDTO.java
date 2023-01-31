package com.manager.cfa_jan2023.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BattleDTO {

    private long id;
    private TeamDTO teamA;
    private TeamDTO teamB;
    private boolean youWon;
}
