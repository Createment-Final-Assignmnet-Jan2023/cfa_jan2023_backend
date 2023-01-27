package com.manager.cfa_jan2023.service.dto;

import com.manager.cfa_jan2023.repository.model.Pokemon;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BattleDTO {
    @Id
    private long id;
}