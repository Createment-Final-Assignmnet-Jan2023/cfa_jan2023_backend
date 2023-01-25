package com.manager.cfa_jan2023;

import com.manager.cfa_jan2023.repository.PokemonRepository;
import com.manager.cfa_jan2023.repository.model.Pokemon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.manager.cfa_jan2023.Battler.battle;

@SpringBootApplication
public class CfaJan2023Application {

	public static void main(String[] args) {
		SpringApplication.run(CfaJan2023Application.class, args);

	}

}
