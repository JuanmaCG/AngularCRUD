package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entity.Asignatura;


@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, String>{

}
