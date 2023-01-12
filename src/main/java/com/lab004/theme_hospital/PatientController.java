package com.lab004.theme_hospital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lab004.theme_hospital.Service.PatientService;
import com.lab004.theme_hospital.models.Consultation;
import com.lab004.theme_hospital.models.Medecin;
import com.lab004.theme_hospital.models.Patient;

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
	
	@GetMapping(path="/{nom}")
	public ResponseEntity<Medecin> getMedecinByNom(String nom) {
		try {
			return new ResponseEntity<>(patientService.getMedecinByNom(nom), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path="/")
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
		try {
			return new ResponseEntity<>(patientService.savePatient(patient), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = "/{id}")
    public ResponseEntity<Patient>  updatePatient(@PathVariable Long id,@RequestBody Patient patient) {
        try {
            return new ResponseEntity<Patient>(patientService.updatePatient(id, patient), HttpStatus.OK) ;
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@PutMapping(path = "/consultation/{id}")
    public ResponseEntity<Consultation>  updateConsultation(@PathVariable Long id, @RequestBody Consultation consultation) {
        try {
            return new ResponseEntity<Consultation>(patientService.updateConsultation(id, consultation), HttpStatus.OK) ;
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	
	@DeleteMapping(path="/{id}")
	public void deletePatient(@PathVariable Long id) {
		patientService.deletePatient(id);
	}
	
}	
