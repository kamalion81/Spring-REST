/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.rest;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Kamalion
 */
public class Holidays implements Serializable{
    
    private List<Holiday> holidays;

    public Holidays() {
    }

    public Holidays(List<Holiday> holidays) {
        this.holidays = holidays;
    }

    public List<Holiday> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<Holiday> holidays) {
        this.holidays = holidays;
    }
    
    
    
    
    
}
