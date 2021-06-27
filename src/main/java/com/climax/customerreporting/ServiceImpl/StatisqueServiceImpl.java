/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.climax.customerreporting.ServiceImpl;

import com.climax.customerreporting.domaines.Employers;
import com.climax.customerreporting.domaines.Profession;
import com.climax.customerreporting.repository.EmployerRepository;
import com.climax.customerreporting.services.Statisitques;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TAPSOBA PC
 */

@Service
@Transactional
public class StatisqueServiceImpl implements Statisitques{
    
    @Autowired
    EmployerRepository dao;

    @Override
    public Map<Profession, Double> findByAverageProfessionalSalaire() {
        return dao.findAll().
                stream().collect(Collectors.groupingBy(e->e.getProfession(),Collectors.averagingLong(e->e.getProfession().getSalaireProfession())));
        
    }

   

   
    
}
