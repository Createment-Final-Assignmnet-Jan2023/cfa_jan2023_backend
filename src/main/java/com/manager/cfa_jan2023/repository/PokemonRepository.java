package com.manager.cfa_jan2023.repository;

import com.manager.cfa_jan2023.repository.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon,Long> {
    //database related code

}
