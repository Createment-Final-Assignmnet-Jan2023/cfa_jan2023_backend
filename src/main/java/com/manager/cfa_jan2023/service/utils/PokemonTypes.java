package com.manager.cfa_jan2023.service.utils;

public enum PokemonTypes {
    NORMAL(0),
    FIGHTING(1),
    FLYING(2),
    POISON(3),
    GROUND(4),
    ROCK(5),
    BUG(6),
    GHOST(7),
    FIRE(8),
    WATER(9),
    GRASS(10),
    ELECTRIC(11),
    PSYCHIC(12),
    ICE(13),
    DRAGON(14);

    final int typeKey;

    PokemonTypes(int typeKey) {
        this.typeKey = typeKey;
    }
}
