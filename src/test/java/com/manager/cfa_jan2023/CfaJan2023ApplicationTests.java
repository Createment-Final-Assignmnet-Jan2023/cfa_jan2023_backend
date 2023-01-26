package com.manager.cfa_jan2023;


import com.manager.cfa_jan2023.service.utils.PokemonBattler;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CfaJan2023ApplicationTests {

//	@Test
//	void contextLoads() {
//
//	}


	@Test
	void shouldReturnCombatScoreOfHalf(){
		PokemonBattler pokemonBattler = new PokemonBattler();
		assertEquals(0.5, pokemonBattler.getAttackScore(List.of("Grass"), List.of("Rock", "Fire")));

	}



}
