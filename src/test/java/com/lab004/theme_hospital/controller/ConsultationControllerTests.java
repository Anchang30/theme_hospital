package com.lab004.theme_hospital.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.lab004.theme_hospital.ConsultationController;
import com.lab004.theme_hospital.Service.ConsultationService;
import com.lab004.theme_hospital.models.Consultation;
import com.lab004.theme_hospital.models.Medecin;
import com.lab004.theme_hospital.models.Patient;


@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class ConsultationControllerTests {
	@InjectMocks
	private ConsultationController consultationController;
	
	@Mock
	private ConsultationService consultationService;

	
	
	@Test
	public void getConsultation_withoutException() {
		
		//Given 
		List<Consultation> list = new ArrayList<>();
		
		Consultation firstConsultation = new Consultation();
		Consultation secondConsultation = new Consultation();
		
		list.add(secondConsultation);
		list.add(firstConsultation);
		
		//When 
		Mockito.when(consultationService.getConsultation()).thenReturn(list);
		ResponseEntity<List<Consultation>> resultat = consultationController.getConsultation();
		
		
		//Then 
		assertEquals(2, resultat.getBody().size());
		assertEquals(HttpStatus.OK, resultat.getStatusCode());
	}
	

	
	@Test(expected = NullPointerException.class)
	public void getConsultation_withException() throws Exception {
		
		when(consultationService.getConsultation()).thenThrow(new NullPointerException("Error occured"));
		//Then
		assertTrue(consultationController.getConsultation().getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	@Test
	public void getConsultationById() throws Exception {
		
		//given
		Consultation consultation = new Consultation();
		
		consultation.setId_consultation(45L);
		
		//when
		
		Mockito.when(consultationService.findById(45L)).thenReturn(consultation);
		ResponseEntity<Consultation> response =  consultationController.getConsultationById(45L);
		
		//Then
		assertEquals(HttpStatus.OK, response.getStatusCode());	
	}
	
	@Test(expected = NullPointerException.class)
	public void getPatientByName_withException() throws Exception {
		
		when(consultationService.findById( 44L)).thenThrow(new NullPointerException("Error occured"));
		//Then
		assertTrue(consultationController.getConsultationById(44L).getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	@Test
	public void updateConsultation_WhitoutException() throws Exception {
		
		//given
		Medecin medecin = new Medecin();
		medecin.setId(5L);
		medecin.setNom("BOUM");
		medecin.setPrenom("Fil");
		medecin.setAdresse_hospital("20 rue du blessé");
		
		Patient patient = new Patient();
		patient.setId(3L);
		patient.setNom("BOU");
		patient.setPrenom("Gilles");
		patient.setAdresse("20 rue de la rue");
		
		Consultation consultation = new Consultation();
		consultation.setId_consultation(44L);
		consultation.setDate_rdv(LocalDate.of(2022, 01, 22));
		consultation.setHeure_rdv(LocalTime.of(12, 30));
		consultation.setMotif("maux de tete");

		//When
		Mockito.when(consultationService.updateConsultation(44L, consultation)).thenReturn(consultation);
		ResponseEntity<Consultation> response = consultationController.updateConsultation(44L, consultation);
		
		//Then
		assertThat(response.getBody().getId_consultation());
		
	}
	
	@Test(expected = NullPointerException.class)
	public void updateConsultation_withException() throws Exception {
		
		//Given
		
		Medecin medecin = new Medecin();
		medecin.setId(5L);
		medecin.setNom("BOUM");
		medecin.setPrenom("Fil");
		medecin.setAdresse_hospital("20 rue du blessé");
		
		Patient patient = new Patient();
		patient.setId(3L);
		patient.setNom("BOU");
		patient.setPrenom("Gilles");
		patient.setAdresse("20 rue de la rue");
		
		
		Consultation consultation = new Consultation();
		consultation.setId_consultation(44L);
		consultation.setDate_rdv(LocalDate.of(2022, 01, 22));
		consultation.setHeure_rdv(LocalTime.of(12, 30));
		consultation.setMotif("maux de tete");
		consultation.setMedecin(medecin);
		consultation.setPatient(patient);
		
		
		when(consultationService.updateConsultation(44L, consultation)).thenThrow(new NullPointerException("Error occured"));
		//Then
		assertTrue(consultationController.updateConsultation(44L, consultation).getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@Test
	public void createConsultation_WhitoutException() throws Exception {
		
		//given
		Medecin medecin = new Medecin();
		medecin.setId(5L);
		medecin.setNom("BOUM");
		medecin.setPrenom("Fil");
		medecin.setAdresse_hospital("20 rue du blessé");
		
		Patient patient = new Patient();
		patient.setId(3L);
		patient.setNom("BOU");
		patient.setPrenom("Gilles");
		patient.setAdresse("20 rue de la rue");
		
		
		Consultation consultation = new Consultation();
		consultation.setId_consultation(44L);
		consultation.setDate_rdv(LocalDate.of(2022, 01, 22));
		consultation.setHeure_rdv(LocalTime.of(12, 30));
		consultation.setMotif("maux de tete");
		consultation.setMedecin(medecin);
		consultation.setPatient(patient);
		
		//When
		Mockito.when(consultationService.saveConsultation(consultation)).thenReturn(consultation);
		ResponseEntity<Consultation> response = consultationController.saveConsultation(consultation);
		
		//Then
		assertThat(response.getBody().getId_consultation()).isGreaterThan(0);
		
	}
	@Test(expected = NullPointerException.class)
	public void createConsultation_withException() throws Exception {
		
		//Given
		Medecin medecin = new Medecin();
		medecin.setId(5L);
		medecin.setNom("BOUM");
		medecin.setPrenom("Fil");
		medecin.setAdresse_hospital("20 rue du blessé");
		
		Patient patient = new Patient();
		patient.setId(3L);
		patient.setNom("BOU");
		patient.setPrenom("Gilles");
		patient.setAdresse("20 rue de la rue");
		
		
		Consultation consultation = new Consultation();
		consultation.setId_consultation(44L);
		consultation.setDate_rdv(LocalDate.of(2022, 01, 22));
		consultation.setHeure_rdv(LocalTime.of(12, 30));
		consultation.setMotif("maux de tete");
		consultation.setMedecin(medecin);
		consultation.setPatient(patient);
		
		when(consultationService.saveConsultation(consultation)).thenThrow(new NullPointerException("Error occured"));
		//Then
		assertTrue(consultationController.saveConsultation(consultation).getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@Test
	public void deleteConsultation() throws Exception {
		
		Medecin medecin = new Medecin();
		medecin.setId(5L);
		medecin.setNom("BOUM");
		medecin.setPrenom("Fil");
		medecin.setAdresse_hospital("20 rue du blessé");
		
		Patient patient = new Patient();
		patient.setId(3L);
		patient.setNom("BOU");
		patient.setPrenom("Gilles");
		patient.setAdresse("20 rue de la rue");
		
		
		Consultation consultation = new Consultation();
		consultation.setId_consultation(44L);
		consultation.setDate_rdv(LocalDate.of(2022, 01, 22));
		consultation.setHeure_rdv(LocalTime.of(12, 30));
		consultation.setMotif("maux de tete");
		consultation.setMedecin(medecin);
		consultation.setPatient(patient);
		
		
		consultationController.deleteConsultation(44L);
		ResponseEntity<Consultation> retrievedPatient = consultationController.getConsultationById(44L);
		
		//Then
		assertThat(retrievedPatient.getBody()).isNull();
		
		
	}
	
}
