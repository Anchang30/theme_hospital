package com.lab004.theme_hospital.DAO;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lab004.theme_hospital.models.Medecin;
import com.lab004.theme_hospital.models.Patient;

@Repository
public interface MedecinDAO extends CrudRepository<Medecin, Long>{

	Optional<Medecin> findByNom(String nom);
}
