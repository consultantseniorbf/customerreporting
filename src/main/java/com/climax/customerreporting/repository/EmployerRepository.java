package com.climax.customerreporting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climax.customerreporting.domaines.Employers;

/**
 * 
 * Repository Employé 
 *
 */
public interface EmployerRepository extends JpaRepository<Employers, Long> {

}
