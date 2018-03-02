/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.rest;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Kamalion
 */
public interface HolidayRepository extends CrudRepository<Holiday, Long>{
    
    
}
