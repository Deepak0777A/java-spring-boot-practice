package com.postgresql.postgresqldemo.repository;

import com.postgresql.postgresqldemo.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepo extends JpaRepository<School,Long> {

}
