package com.manager.cfa_jan2023.service.mapper;


import com.manager.cfa_jan2023.repository.model.Battle;
import com.manager.cfa_jan2023.repository.model.Team;
import com.manager.cfa_jan2023.service.dto.BattleDTO;
import com.manager.cfa_jan2023.service.dto.TeamDTO;

public class BattleMapper {
    public static BattleDTO toDto(Battle entity) {
        return BattleDTO.builder()
                .id(entity.getId())
                .build();
    }

    public static Battle toEntity(BattleDTO battleDTO) {
        return Battle.builder()
                .id(battleDTO.getId())
                .build();
    }
}
