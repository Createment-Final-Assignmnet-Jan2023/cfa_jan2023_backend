package com.manager.cfa_jan2023.repository;

import com.manager.cfa_jan2023.repository.model.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon,Long> {
    //database related code
    Page<Pokemon> findAll(Pageable pageable);
}
