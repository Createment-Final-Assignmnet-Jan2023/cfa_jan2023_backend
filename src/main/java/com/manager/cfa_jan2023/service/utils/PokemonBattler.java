package com.manager.cfa_jan2023.service.utils;

import com.manager.cfa_jan2023.service.dto.PokemonDTO;
import com.manager.cfa_jan2023.service.dto.TeamDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Data
@RequiredArgsConstructor
public class PokemonBattler {
    private static final double[][] POKEMON_TYPE_CHART = {
            {1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0}, //normal
            {2.0, 1.0, 0.5, 0.5, 1.0, 2.0, 0.5, 0.0, 1.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0}, //fight
            {1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0, 1.0}, //flying
            {1.0, 1.0, 1.0, 0.5, 0.5, 0.5, 2.0, 0.5, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0}, //poison
            {1.0, 1.0, 0.0, 2.0, 1.0, 2.0, 0.5, 1.0, 2.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0}, //ground
            {1.0, 0.5, 2.0, 1.0, 0.5, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0}, //rock
            {1.0, 0.5, 0.5, 2.0, 1.0, 1.0, 1.0, 0.5, 0.5, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0}, //bug
            {0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0}, //ghost
            {1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 0.5, 0.5, 2.0, 1.0, 1.0, 2.0, 0.5}, //fire
            {1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 1.0, 1.0, 2.0, 0.5, 0.5, 1.0, 1.0, 1.0, 2.0}, //water
            {1.0, 1.0, 0.5, 0.5, 2.0, 2.0, 0.5, 1.0, 0.5, 2.0, 0.5, 1.0, 1.0, 1.0, 0.5}, //grass
            {1.0, 1.0, 2.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 0.5, 1.0, 1.0, 0.5}, //electric
            {1.0, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0}, //psychic
            {1.0, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 1.0, 0.5, 2.0}, //ice
            {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0}  //dragon
    };
    Random random = new Random();

    public boolean isTeamAVictorious(TeamDTO teamA, TeamDTO teamB) {
        int livesA = teamA.getTeamMembers().size();
        int livesB = teamB.getTeamMembers().size();
        while (livesA > 0 && livesB > 0) {
            PokemonDTO combatantA = teamA.getTeamMembers().get(livesA - 1);
            PokemonDTO combatantB = teamB.getTeamMembers().get(livesB - 1);
            PokemonDTO loser = battle(combatantA, combatantB);
            if (loser == combatantA) {
                livesA--;
            } else {
                livesB--;
            }
        }
        return livesB==0;
    }

    private PokemonDTO battle(PokemonDTO combatantA, PokemonDTO combatantB) {
        double combatScoreA = getAttackScore(combatantA.getTypes(), combatantB.getTypes());
        double combatScoreB = getAttackScore(combatantB.getTypes(), combatantA.getTypes());
        if (combatScoreA == combatScoreB) {
            return flipACoin(combatantA, combatantB);
        } else if (combatScoreA < combatScoreB) {
            return combatantA;
        } else {
            return combatantB;
        }
    }

    PokemonDTO flipACoin(PokemonDTO a, PokemonDTO b) {
        return switch (random.nextInt(2)) {
            case 0 -> a;
            case 1 -> b;
            default -> null;
        };
    }

    double getAttackScore(List<String> attackerType, List<String> defenderType) {
        List<Double> combatScoresB = new ArrayList<>();
        defenderType.forEach(type -> combatScoresB.add(
                POKEMON_TYPE_CHART[convertTypeToInt(attackerType.get(0))][convertTypeToInt(type)]));
        return Collections.min(combatScoresB);
    }

    int convertTypeToInt(String type) {
        List<PokemonTypes> pokemonTypesList = List.of(PokemonTypes.values());
        for (int i = 0; i < pokemonTypesList.size(); i++) {
            if (pokemonTypesList.get(i).toString().equalsIgnoreCase(type)) {
                System.out.println(type + " equals index " +pokemonTypesList.get(i).toString());
                return i;
            }
        }
        System.out.println(type);
        return -1;
    }
}
