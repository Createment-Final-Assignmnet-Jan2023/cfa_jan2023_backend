package com.manager.cfa_jan2023.repository;

import com.manager.cfa_jan2023.repository.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {
    //database related code

}
