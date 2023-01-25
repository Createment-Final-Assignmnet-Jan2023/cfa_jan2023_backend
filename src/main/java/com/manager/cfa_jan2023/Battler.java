package com.manager.cfa_jan2023;

import com.manager.cfa_jan2023.repository.model.Pokemon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@Data
@RequiredArgsConstructor
public class Battler {

    public static Pokemon battle(Pokemon combatantA, Pokemon combatantB){
        //each pokemon picks random attack move (give choice to player?)

        //compare type of attack to type1 of pokemon. let 'strong' attacks automatically win.

        //if all else fails, flip a coin
        return flipACoin(combatantA,combatantB);
    }
    public static Pokemon flipACoin(Pokemon combatantA, Pokemon combatantB) {
        Random random = new Random();
        return switch (random.nextInt(2)) {
            case 0 -> combatantA;
            case 1 -> combatantB;
            default -> null;
        };
    }
}
