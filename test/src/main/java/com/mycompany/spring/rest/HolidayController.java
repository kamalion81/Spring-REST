/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Контроллер MVC для отпусков
 * @author kamalion
 */
@Controller
@RequestMapping(value = "/holiday")
public class HolidayController {
    
    @Autowired
    private HolidayService service;
    
    /**
     * Получает список всех отпусков
     * @return список отпусков
     */
    @RequestMapping(value = "/listholiday", method = RequestMethod.GET)
    @ResponseBody
    public Holidays listData(){
        return new Holidays(service.findAll());
    }
    
    /**
     * Получает отпуск по id
     * @param id
     * @return отпуск
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Holiday findHolidayById(@PathVariable Long id){
        return service.findById(id);
    }
    
    /**
     * Создает новый отпуск
     * @param holiday
     * @return созданные отпуск
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Holiday create(@RequestBody Holiday holiday){
        service.save(holiday);
        return holiday;
        
    }
    
    /**
     * Редактирует существующий отпуск
     * @param holiday 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void update(@RequestBody Holiday holiday){
        service.save(holiday);
    }
    
    /**
     * Удаляет выбранный отпуск по id
     * @param id 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable Long id){
        Holiday holiday = service.findById(id);
        service.delete(holiday);
    }
    
}
