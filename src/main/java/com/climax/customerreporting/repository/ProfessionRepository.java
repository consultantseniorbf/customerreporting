package com.climax.customerreporting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climax.customerreporting.domaines.Profession;
import java.util.Optional;

/**
 * 
 * Repository Profession 
 *
 */
public interface ProfessionRepository extends JpaRepository<Profession, Long> {
	
	public Optional<Profession> findByLibelleProfession(String profession);

}
