/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.rest;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * Отпуск
 * @author Kamalion
 */
@Entity
@Table(name = "holidays")
public class Holiday {

    private Long id;
    
    private DateTime dateBegin;
    private int duration;
    private Statuses status;
    private User user;
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //Пользователь
    @OneToOne(cascade = CascadeType.PERSIST)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //Дата
    @Column(name = "DATE_BEGIN")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(DateTime date) {
        this.dateBegin = date;
    }

    //Продолжительность
    @Column(name = "DURATION")
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    //Статус отпуска
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    public Statuses getStatus() {
        return status;
    }

    public void setStatus(Statuses status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Holiday{" + "dateBegin= " + dateBegin + ", duration= " + duration + ", status= " + status + ", user= " + user + '}';
    }
    
    

    
    
    
    
    
}
