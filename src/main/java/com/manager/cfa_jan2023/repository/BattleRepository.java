package com.manager.cfa_jan2023.repository;

import com.manager.cfa_jan2023.repository.model.Battle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BattleRepository extends JpaRepository<Battle,Long> {
    //database related code

}
