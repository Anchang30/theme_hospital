package com.lab004.theme_hospital.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.lab004.theme_hospital.PatientController;
import com.lab004.theme_hospital.Service.PatientService;
import com.lab004.theme_hospital.models.Patient;






@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class PatientControllerTests {

	@InjectMocks
	private PatientController patientController;
	
	@Mock
	private PatientService patientService;
	
	@Test
	public void getPatient_withoutException() {
		
		//Given 
		List<Patient> list = new ArrayList<>();
		
		Patient firstPatient = new Patient();
		Patient secondPatient = new Patient();
		
		list.add(secondPatient);
		list.add(firstPatient);
		
		//When 
		Mockito.when(patientService.getPatient()).thenReturn(list);
		ResponseEntity<List<Patient>> resultat = patientController.getPatient();
		
		
		//Then 
		assertEquals(2, resultat.getBody().size());
		assertEquals(HttpStatus.OK, resultat.getStatusCode());
	}
	
	
	@Test(expected = NullPointerException.class)
	public void getpatient_withException() throws Exception {
		
		when(patientService.getPatient()).thenThrow(new NullPointerException("Error occured"));
		//Then
		assertTrue(patientController.getPatient().getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	
//	public void getPatientByName
	
	@Test
	public void getPatientByName() throws Exception {
		
		//given
		Patient patient = new Patient();
		
		patient.setNom("LOUNES");
		
		//when
		
		Mockito.when(patientService.findByNom("LOUNES")).thenReturn(patient);
		ResponseEntity<Patient> response =  patientController.getPatientByName("LOUNES");
		
		//Then
		assertEquals(HttpStatus.OK, response.getStatusCode());	
	}
	
	@Test(expected = NullPointerException.class)
	public void getPatientByName_withException() throws Exception {
		
		when(patientService.findByNom( "J")).thenThrow(new NullPointerException("Error occured"));
		//Then
		assertTrue(patientController.getPatientByName("J").getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@Test
	public void createPatient_WhitoutException() throws Exception {
		
		//given
		Patient patient = new Patient();
		patient.setId(3L);
		patient.setNom("BOU");
		patient.setPrenom("Gilles");
		patient.setAdresse("20 rue de la rue");
		
		//When
		Mockito.when(patientService.savePatient(patient)).thenReturn(patient);
		ResponseEntity<Patient> response = patientController.savePatient(patient);
		
		//Then
		assertThat(response.getBody().getId()).isGreaterThan(0);
		
	}
	@Test(expected = NullPointerException.class)
	public void createPatient_withException() throws Exception {
		
		//Given
		Patient patient = new Patient();
		patient.setId(3L);
		patient.setNom("BOU");
		patient.setPrenom("Gilles");
		patient.setAdresse("20 rue de la rue");
		
		when(patientService.savePatient(patient)).thenThrow(new NullPointerException("Error occured"));
		//Then
		assertTrue(patientController.savePatient(patient).getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	
	
	@Test
	public void updatePatient_WhitoutException() throws Exception {
		
		//given
		Patient patient = new Patient();
		patient.setId(3L);
		patient.setNom("BOU");
		patient.setPrenom("Gilles");
		patient.setAdresse("20 rue de la rue");
		
		//When
		Mockito.when(patientService.updatePatient(3L, patient)).thenReturn(patient);
		ResponseEntity<Patient> response = patientController.updatePatient(3L, patient);
		
		//Then
		assertThat(response.getBody());
		
	}
	
	@Test(expected = NullPointerException.class)
	public void updatePatient_withException() throws Exception {
		
		//Given
		Patient patient = new Patient();
		patient.setId(3L);
		patient.setNom("BOU");
		patient.setPrenom("Gilles");
		patient.setAdresse("20 rue de la rue");
		
		when(patientService.updatePatient(3L, patient)).thenThrow(new NullPointerException("Error occured"));
		//Then
		assertTrue(patientController.updatePatient(3L, patient).getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	
	@Test
	public void deletePatient() throws Exception {
		
		Patient patient = new Patient();
		patient.setId(3L);
		patient.setNom("BOU");
		patient.setPrenom("Gilles");
		patient.setAdresse("20 rue de la rue");
		
		patientController.deletePatient(3L);
		ResponseEntity<Patient> retrievedPatient = patientController.getPatientByName("BOU");
		
		//Then
		assertThat(retrievedPatient.getBody()).isNull();
		
		
	}
	
}
