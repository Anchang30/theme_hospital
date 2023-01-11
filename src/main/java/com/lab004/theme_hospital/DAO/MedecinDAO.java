package com.lab004.theme_hospital.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lab004.theme_hospital.models.Medecin;

@Repository
public interface MedecinDAO extends CrudRepository<Medecin, Long>{

}
