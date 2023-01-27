package com.manager.cfa_jan2023.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="battles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Battle {
    @Id
    private Long id;
}
