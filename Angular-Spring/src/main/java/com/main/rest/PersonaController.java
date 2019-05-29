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

import com.main.entity.Persona;
import com.main.errors.ResourceNotFoundException;
import com.main.repository.PersonaRepository;

@RestController
@RequestMapping("/")
public class PersonaController {

	@Autowired
	private PersonaRepository personaRepository;
	
	@GetMapping("/persona")
	public List<Persona> getAllPersona(){
		return personaRepository.findAll();
	}
	
	@GetMapping("/persona/{dni}")
    public ResponseEntity<Persona> getPersonaByDni(@PathVariable(value = "dni") String dni)
        throws ResourceNotFoundException {
        Persona persona = personaRepository.findById(dni)
          .orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada con este dni :: " + dni));
        return ResponseEntity.ok().body(persona);
    }
	
	@PostMapping("/persona")
	public Persona crearPersona(@Valid @RequestBody Persona persona) {
		return personaRepository.save(persona);
	}
	
	@PutMapping("/persona/{dni}")
	public ResponseEntity<Persona> updatePersona(@PathVariable(value="dni") String dni,
			@Valid @RequestBody Persona personaDetails) throws ResourceNotFoundException {
			Persona persona = personaRepository.findById(dni)
					.orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada con este dni :: " + dni));
			persona.setDni(personaDetails.getDni());
			persona.setApellido(personaDetails.getApellido());
			persona.setCiudad(personaDetails.getCiudad());
			persona.setDireccioncalle(personaDetails.getDireccioncalle());
			persona.setDireccionnum(personaDetails.getDireccionnum());
			persona.setNombre(personaDetails.getNombre());
			persona.setTelefono(personaDetails.getTelefono());
			persona.setVaron(personaDetails.getVaron());
			
			final Persona updatedPersona = personaRepository.save(persona);
			
			return ResponseEntity.ok(updatedPersona);

	}
	
	@DeleteMapping("/persona/{dni}")
    public Map<String, Boolean> deletePersona(@PathVariable(value = "dni") String dni)
         throws ResourceNotFoundException {
        Persona persona = personaRepository.findById(dni)
       .orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada con este dni :: " + dni));

        personaRepository.delete(persona);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
