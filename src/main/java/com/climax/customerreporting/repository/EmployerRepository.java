package com.climax.customerreporting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climax.customerreporting.domaines.Employers;
import java.util.List;

/**
 * 
 * Repository Employé 
 *
 */
public interface EmployerRepository extends JpaRepository<Employers, Long> {

    //public List<Employers> findByEmployers_Profession();
}
