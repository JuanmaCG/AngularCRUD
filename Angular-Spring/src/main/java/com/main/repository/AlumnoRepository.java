package com.main.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entity.Alumno;



@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, String>{


	
}
