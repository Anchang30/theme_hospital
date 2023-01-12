package com.lab004.theme_hospital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab004.theme_hospital.Service.MedecinService;
import com.lab004.theme_hospital.models.Consultation;
import com.lab004.theme_hospital.models.Medecin;
import com.lab004.theme_hospital.models.Patient;
 
@RestController
@RequestMapping(path = "/api/medecins")
public class MedecinController {
	
	@Autowired
	private MedecinService medecinService;
	

	
	/// GET MEDECIN BY NAME A IMPLEMENTER COMME AVEC PATIENTS
	
	@GetMapping(path ="/")
	public ResponseEntity<List<Medecin>> getMedecins() {
		try {
			List<Medecin> medecins = medecinService.getMedecins();
			return new ResponseEntity<>(medecins, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@PostMapping(path="/")
	public ResponseEntity<Medecin> saveMedecin(@RequestBody Medecin medecin) {
		try {
			return new ResponseEntity<>(medecinService.saveMedecin(medecin), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping(path = "/{id}")
    public ResponseEntity<Medecin>  updateMedecin(@PathVariable Long id,@RequestBody Medecin medecin) {
        try {
            return new ResponseEntity<Medecin>(medecinService.updateMedecin(id, medecin), HttpStatus.OK) ;
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
	
	@DeleteMapping(path="/{id}")
	public void deleteMedecin(@PathVariable Long id) {
		medecinService.deleteMedecin(id);
	}
	

}
