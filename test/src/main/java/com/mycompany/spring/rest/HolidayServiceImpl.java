/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.rest;

import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Реализация сервиса для отпусков
 * @author Kamalion
 */
@Service("holidayService")
@Repository
@Transactional
public class HolidayServiceImpl implements HolidayService{
    
    @Autowired
    private HolidayRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Holiday save(Holiday holiday) {
        return repository.save(holiday);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Holiday> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public void delete(Holiday holiday) {
        repository.delete(holiday);
    }
    
    @Override
    public Holiday findById(Long id){
        return repository.findOne(id);
    }
    
}
