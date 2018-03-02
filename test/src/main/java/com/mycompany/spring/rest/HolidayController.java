/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Valya
 */
@Controller
@RequestMapping(value = "/holiday")
public class HolidayController {
    
    @Autowired
    private HolidayService service;
    
    @RequestMapping(value = "/listholiday", method = RequestMethod.GET)
    @ResponseBody
    public Holidays listData(){
        return new Holidays(service.findAll());
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Holiday create(@RequestBody Holiday holiday){
        service.save(holiday);
        return holiday;
        
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void update(@RequestBody Holiday holiday){
        
    }
    
}
