package com.main.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Alumno;
import com.main.entity.Persona;
import com.main.errors.ResourceNotFoundException;
import com.main.repository.AlumnoRepository;

@RestController
@RequestMapping("/")
public class AlumnoController {

	@Autowired
	AlumnoRepository alumnoRepository;
	
	@GetMapping("/alumno")
	public List<Alumno> getAllAlumnos(){
		return alumnoRepository.findAll();
	}
	
	@GetMapping("/alumno/{dni}")
	public ResponseEntity<Alumno> getAlumnoById(@PathVariable(value = "dni") String dni)
        throws ResourceNotFoundException {
        Alumno alumno = alumnoRepository.findById(dni)
          .orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrada con este id :: " + dni));
        return ResponseEntity.ok().body(alumno);
    }
	
	@PostMapping("/alumno")
	public Persona crearPersona(@Valid @RequestBody Alumno alumno) {
		return alumnoRepository.save(alumno);
	}
	
	@PutMapping("/alumno/{dni}")
	public ResponseEntity<Alumno> updateAlumno(@PathVariable(value="dni") String dni,
			@Valid @RequestBody Alumno alumnoDetails) throws ResourceNotFoundException {
			Alumno alumno = alumnoRepository.findById(dni)
					.orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrada con este id :: " + dni));
			alumno.setDni(alumno.getDni());
			alumno.setIdalumno(alumnoDetails.getIdalumno());

			
			final Alumno updatedAlumno = alumnoRepository.save(alumno);
			
			return ResponseEntity.ok(updatedAlumno);

	}
	
	@DeleteMapping("/alumno/{dni}")
    public Map<String, Boolean> deleteAlumno(@PathVariable(value = "dni") String dni)
         throws ResourceNotFoundException {
		Alumno alumno = alumnoRepository.findById(dni)
       .orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrada con este dni :: " + dni));

        alumnoRepository.delete(alumno);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
