package com.main.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entity.Titulacion;


@Repository
public interface TitulacionRepository extends JpaRepository<Titulacion, String>{
		 

	 
}
