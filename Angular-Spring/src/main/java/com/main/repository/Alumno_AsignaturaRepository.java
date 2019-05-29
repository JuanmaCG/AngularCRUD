package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entity.Alumno_Asignatura;
import com.main.entity.Alumno_Asignatura.Composited_pk;

@Repository
public interface Alumno_AsignaturaRepository extends JpaRepository<Alumno_Asignatura, Composited_pk>{

}
