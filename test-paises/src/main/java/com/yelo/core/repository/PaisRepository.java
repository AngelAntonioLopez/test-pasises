package com.yelo.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yelo.core.Entity.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{

}
