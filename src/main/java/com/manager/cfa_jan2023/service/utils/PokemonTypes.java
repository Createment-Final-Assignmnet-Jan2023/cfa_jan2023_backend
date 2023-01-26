package com.manager.cfa_jan2023.service.utils;

import lombok.Data;


public enum PokemonTypes {
    Normal(0,"#A8A77A"),
    Fight(1,"#EE8130"),
    Flying(2,"#6390F0"),
    Poison(3,"#F7D02C"),
    Ground(4,"#7AC74C"),
    Rock(5,"#96D9D6"),
    Bug(6,"#C22E28"),
    Ghost(7,"#A33EA1"),
    Fire(8,"#E2BF65"),
    Water(9,"#A98FF3"),
    Grass(10,"#F95587"),
    Electric(11,"#A6B91A"),
    Psychic(12,"#B6A136"),
    Ice(13,"#735797"),
    Dragon(14,"#6F35FC");

    int typeKey;
    String typeHex;
    PokemonTypes(int typeKey, String typeHex) {
        this.typeKey = typeKey;
        this.typeHex = typeHex;
    }

    public int getTypeKey() {
        return typeKey;
    }
}
