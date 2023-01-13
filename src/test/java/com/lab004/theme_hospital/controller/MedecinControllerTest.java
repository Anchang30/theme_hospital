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

import com.lab004.theme_hospital.MedecinController;
import com.lab004.theme_hospital.Service.MedecinService;
import com.lab004.theme_hospital.models.Medecin;




@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class MedecinControllerTest {
	@InjectMocks
	private MedecinController medecinController;
	
	@Mock
	private MedecinService medecinService;
	
	@Test
	public void getMedecin_withoutException() {
		
		//Given 
		List<Medecin> list = new ArrayList<>();
		
		Medecin firstMedecin = new Medecin();
		Medecin secondMedecin = new Medecin();
		
		list.add(secondMedecin);
		list.add(firstMedecin);
		
		//When 
		Mockito.when(medecinService.getMedecins()).thenReturn(list);
		ResponseEntity<List<Medecin>> resultat = medecinController.getMedecins();
		
		
		//Then 
		assertEquals(2, resultat.getBody().size());
		assertEquals(HttpStatus.OK, resultat.getStatusCode());
	}
	
	@Test
	public void getMedecinByName() throws Exception {
		
		//given
		Medecin medecin = new Medecin();
		
		medecin.setNom("LOUNES");
		
		//when
		
		Mockito.when(medecinService.findByNom("LOUNES")).thenReturn(medecin);
		ResponseEntity<Medecin> response =  medecinController.getMedecinByName("LOUNES");
		
		//Then
		assertEquals(HttpStatus.OK, response.getStatusCode());	
	}
	
	@Test(expected = NullPointerException.class)
	public void getPatientByName_withException() throws Exception {
		
		when(medecinService.findByNom( "J")).thenThrow(new NullPointerException("Error occured"));
		//Then
		assertTrue(medecinController.getMedecinByName("J").getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@Test(expected = NullPointerException.class)
	public void getMedecin_withException() throws Exception {
		
		when(medecinService.getMedecins()).thenThrow(new NullPointerException("Error occured"));
		//Then
		assertTrue(medecinController.getMedecins().getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	@Test
	public void createMedecin_WhitoutException() throws Exception {
		
		//given
		Medecin medecin = new Medecin();
		medecin.setId(5L);
		medecin.setNom("BOUM");
		medecin.setPrenom("Fil");
		medecin.setAdresse_hospital("20 rue du blessé");
		
		//When
		Mockito.when(medecinService.saveMedecin(medecin)).thenReturn(medecin);
		ResponseEntity<Medecin> response = medecinController.saveMedecin(medecin);
		
		//Then
		assertThat(response.getBody().getId()).isGreaterThan(0);
		
	}
	
	@Test(expected = NullPointerException.class)
	public void createMedecin_withException() throws Exception {
		
		//given
		Medecin medecin = new Medecin();
		medecin.setId(5L);
		medecin.setNom("BOUM");
		medecin.setPrenom("Fil");
		medecin.setAdresse_hospital("20 rue du blessé");
		
		when(medecinService.saveMedecin(medecin)).thenThrow(new NullPointerException("Error occured"));
		//Then
		assertTrue(medecinController.saveMedecin(medecin).getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	@Test
	public void updateMedecin_WhitoutException() throws Exception {
		
		//given
		Medecin medecin = new Medecin();
		medecin.setId(5L);
		medecin.setNom("BOUM");
		medecin.setPrenom("Fil");
		medecin.setAdresse_hospital("20 rue du blessé");
		//When
		Mockito.when(medecinService.updateMedecin(3L, medecin)).thenReturn(medecin);
		ResponseEntity<Medecin> response = medecinController.updateMedecin(3L, medecin);
		
		//Then
		assertThat(response.getBody().getId());
		
	}
	
	@Test(expected = NullPointerException.class)
	public void updateMedecin_withException() throws Exception {
		
		//given
		Medecin medecin = new Medecin();
		medecin.setId(5L);
		medecin.setNom("BOUM");
		medecin.setPrenom("Fil");
		medecin.setAdresse_hospital("20 rue du blessé");
		
		when(medecinService.updateMedecin(3L, medecin)).thenThrow(new NullPointerException("Error occured"));
		//Then
		assertTrue(medecinController.updateMedecin(3L, medecin).getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@Test
	public void deleteMedecin() throws Exception {
		
		Medecin medecin = new Medecin();
		medecin.setId(5L);
		medecin.setNom("BOUM");
		medecin.setPrenom("Fil");
		medecin.setAdresse_hospital("20 rue du blessé");
		
		medecinController.deleteMedecin(5L);
		ResponseEntity<Medecin> retrievedMedecin = medecinController.getMedecinByName("BOUM");
		
		//Then
		assertThat(retrievedMedecin.getBody()).isNull();
	}
}
