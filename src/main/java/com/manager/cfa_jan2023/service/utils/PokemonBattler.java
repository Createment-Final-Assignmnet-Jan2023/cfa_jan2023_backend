package com.manager.cfa_jan2023.service.utils;

import com.manager.cfa_jan2023.repository.model.Pokemon;
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


//    public Team teamBattle(Team teamA, Team teamB) {
//        List<Pokemon> battleTeamA = teamA.getTeamMembers();
//        List<Pokemon> battleTeamB = teamB.getTeamMembers();
//        int counter = 1;
//        while (!battleTeamA.isEmpty() && !battleTeamB.isEmpty()) {
//            System.out.println("A - round "+ counter + " - size "+battleTeamA.size());
//            System.out.println("B - round "+ counter + " - size "+battleTeamB.size());
//            Pokemon combatantA = battleTeamA.get(0);
//            Pokemon combatantB = battleTeamB.get(0);
//            Pokemon loser = battle(combatantA, combatantB);
//            if (loser == combatantA) {
//                battleTeamA.remove(combatantA);
//            } else if (loser == combatantB) {
//                battleTeamB.remove(combatantB);
//            }
//            counter++;
//        }
//        if (battleTeamA.isEmpty()) {
//            System.out.println("blah blah");
//            return teamB;
//        }
//        if (battleTeamB.isEmpty()) {
//            System.out.println("toet toet");
//            return teamA;
//
//        }
//        return null;
//    }

    public Pokemon battle(Pokemon combatantA, Pokemon combatantB) {
        double combatScoreA = getAttackScore(combatantA.getTypes(), combatantB.getTypes());
        double combatScoreB = getAttackScore(combatantB.getTypes(), combatantA.getTypes());
        if (combatScoreA == combatScoreB) {
            return (Pokemon) flipACoin(combatantA, combatantB);
        } else if (combatScoreA < combatScoreB) {
            return combatantA;
        } else {
            return combatantB;
        }
    }

    Object flipACoin(Object a, Object b) {
        return switch (random.nextInt(2)) {
            case 0 -> a;
            case 1 -> b;
            default -> null;
        };
    }

    public double getAttackScore(List<String> attackerType, List<String> defenderType) {
        List<Double> combatScoresB = new ArrayList<>();
        defenderType.forEach(type -> combatScoresB.add(POKEMON_TYPE_CHART[convertTypeToInt(attackerType.get(0))][convertTypeToInt(type)]));
        return Collections.min(combatScoresB);

    }

    int convertTypeToInt(String type) {
        List<PokemonTypes> pokemonTypesList = List.of(PokemonTypes.values());
        for (int i = 0; i < pokemonTypesList.size(); i++) {
            if (pokemonTypesList.get(i).toString().equalsIgnoreCase(type)) {
                return i;
            }
        }
        return -1;
    }
}
