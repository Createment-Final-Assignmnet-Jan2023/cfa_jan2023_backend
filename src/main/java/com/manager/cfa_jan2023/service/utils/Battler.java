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
public class Battler {
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

//    public static Team generateARandomTeam(){
//        //generates a team with n random pokemon
//        return null;
//    }

//    public static Team teamBattle(Team teamA, Team teamB){
//        //logic to eliminate one by one goes here, until a winner is there
//        return null;
//    }
    public Pokemon battle(Pokemon combatantA, Pokemon combatantB) {
        double combatScoreA = getAttackScore(combatantA.getTypes(), combatantB.getTypes());
        double combatScoreB = getAttackScore(combatantB.getTypes(), combatantA.getTypes());
        if (combatScoreA == combatScoreB) {
            return flipACoin(combatantA, combatantB);
        } else if (combatScoreA > combatScoreB) {
            return combatantA;
        } else {
            return combatantB;
        }
    }

    static Pokemon flipACoin(Pokemon combatantA, Pokemon combatantB) {
        Random random = new Random();
        return switch (random.nextInt(2)) {
            case 0 -> combatantA;
            case 1 -> combatantB;
            default -> null;
        };
    }

    public double getAttackScore(List<String> attackerType, List<String> defenderType) {
        List<Double> combatScoresB = new ArrayList<>();
        defenderType.forEach(type -> combatScoresB.add(POKEMON_TYPE_CHART[convertTypeToInt(attackerType.get(0))][convertTypeToInt(type)]));
        return Collections.min(combatScoresB);

    }

    public int convertTypeToInt(String type) {
        List<PokemonTypes> pokemonTypesList = List.of(PokemonTypes.values());
        for (int i = 0; i < pokemonTypesList.size(); i++) {
            if (pokemonTypesList.get(i).toString().equalsIgnoreCase(type)) {
                return i;
            }
        }
        return -1;
    }
}
