package com.manager.cfa_jan2023.service;

import com.manager.cfa_jan2023.controller.error.NotFoundException;
import com.manager.cfa_jan2023.repository.BattleRepository;
import com.manager.cfa_jan2023.repository.model.Battle;
import com.manager.cfa_jan2023.service.dto.BattleDTO;
import com.manager.cfa_jan2023.service.dto.TeamDTO;
import com.manager.cfa_jan2023.service.mapper.BattleMapper;
import com.manager.cfa_jan2023.service.utils.PokemonBattler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.manager.cfa_jan2023.service.mapper.BattleMapper.toEntity;

@Service
@RequiredArgsConstructor
public class BattleService {
    //business logic happens here
    private final BattleRepository battleRepository;
    private final TeamService teamService;
    private final PokemonBattler pokemonBattler = new PokemonBattler();

    public BattleDTO getById(long id) {
        Battle battle = battleRepository.findById(id).orElseThrow(() -> new NotFoundException("Battle not found!"));
        return BattleMapper.toDto(battle);
    }

    public List<BattleDTO> getAllBattles() {
        return battleRepository.findAll().stream()
                .map(BattleMapper::toDto)
                .toList();
    }

    public BattleDTO createBattle(TeamDTO teamA) {
        TeamDTO teamB = teamService.generateARandomTeam(teamA.getTeamMembers().size());
        BattleDTO battleDTO = BattleDTO.builder()
                .teamA(teamA)
                .teamB(teamB)
                .youWon(this.pokemonBattler.isTeamAVictorious(teamA, teamB))
                .build();
        Battle savedBattle = battleRepository.save(toEntity(battleDTO));
        return BattleMapper.toDto(savedBattle);
    }

    public BattleDTO createBattle(Long teamId) {
        TeamDTO teamDTO = teamService.getById(teamId);
        return createBattle(teamDTO);
    }

    public void deleteById(Long id) {
        getById(id);
        battleRepository.deleteById(id);
    }
}
