/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.climax.customerreporting.services;


import com.climax.customerreporting.domaines.Profession;
import java.util.Map;

/**
 *
 * @author TAPSOBA PC
 */
public interface Statisitques {
    
    public Map<Profession,Double>findByAverageProfessionalSalaire();
    
}
