/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.rest;

import java.util.List;

/**
 *
 * @author Kamalion
 */
public interface HolidayService {
    
    Holiday findById(Long id);
    List<Holiday> findAll();
    Holiday save(Holiday holiday);
    void delete(Holiday holiday);
    
}
