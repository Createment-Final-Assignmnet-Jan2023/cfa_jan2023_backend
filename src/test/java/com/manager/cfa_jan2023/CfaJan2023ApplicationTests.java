package com.manager.cfa_jan2023;

import com.manager.cfa_jan2023.service.utils.Battler;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CfaJan2023ApplicationTests {

//	@Test
//	void contextLoads() {
//
//	}

	@Test
	void shouldflipACoin(){
		flipACoin();
		//todo: Assertion
	}
//	@Test
//	void shouldGenerateARandomTeam(){
//		//generateARandomTeam();
//		//todo: Assertion
//	}

	@Test
	void shouldReturnCombatScoreofHalf(){
		Battler battler= new Battler();
		assertEquals(battler.getAttackScore(Arrays.asList("Grass"), Arrays.asList("Rock","Fire")),0.5);

	}

}
