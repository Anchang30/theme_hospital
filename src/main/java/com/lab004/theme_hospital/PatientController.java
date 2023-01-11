package com.lab004.theme_hospital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lab004.theme_hospital.Service.PatientService;
import com.lab004.theme_hospital.models.Medecin;

@RestController
@RequestMapping(path="/api/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@GetMapping(path ="/")
	public ResponseEntity<List<Medecin>> getMedecins() {
		try {
			List<Medecin> medecins = patientService.getMedecins();
			return new ResponseEntity<>(medecins, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
		
}	
