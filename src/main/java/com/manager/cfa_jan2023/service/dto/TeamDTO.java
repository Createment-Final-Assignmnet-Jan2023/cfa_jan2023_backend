package com.manager.cfa_jan2023.service.dto;

import com.manager.cfa_jan2023.repository.model.Pokemon;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamDTO {
    @Id
    private long id;
    private List<Pokemon> teamMembers;
    private Long battleId;
}
