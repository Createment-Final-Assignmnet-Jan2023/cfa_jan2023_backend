package com.manager.cfa_jan2023.service.mapper;

import com.manager.cfa_jan2023.repository.model.Battle;
import com.manager.cfa_jan2023.service.dto.BattleDTO;

public class BattleMapper {
    public static BattleDTO toDto(Battle entity) {
        return BattleDTO.builder()
                .id(entity.getId())
                .teamA(TeamMapper.toDto(entity.getTeamA()))
                .teamB(TeamMapper.toDto(entity.getTeamB()))
                .build();
    }

    public static Battle toEntity(BattleDTO battleDTO) {
        return Battle.builder()
                .id(battleDTO.getId())
                .teamA(TeamMapper.toEntity(battleDTO.getTeamA()))
                .teamB(TeamMapper.toEntity(battleDTO.getTeamB()))
                .build();
    }
}
