package com.manager.cfa_jan2023.controller;


import com.manager.cfa_jan2023.service.BattleService;
import com.manager.cfa_jan2023.service.dto.BattleDTO;
import com.manager.cfa_jan2023.service.dto.BattleRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "battle")
@RequiredArgsConstructor
public class BattleController {
    //aka endpoint
    //communicates to outside world
    //data gets pulled in as DTO and converted into 'regular data'
    private final BattleService battleService;

    @GetMapping("{id}")
    public BattleDTO getById(@PathVariable long id) {
        return battleService.getById(id);
    }

    @GetMapping
    public List<BattleDTO> getAllBattles() {
        return battleService.getAllBattles();
    }

    @PostMapping
    public BattleDTO createBattle(@RequestBody BattleRequestDTO battleRequestDTO) {
        return battleService.createBattle(battleRequestDTO.getTeamA());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        battleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
