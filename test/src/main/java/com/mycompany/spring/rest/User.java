/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.rest;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * Класс Пользователь
 * @author Kamalion
 */
@Entity
@Table(name = "users")
public class User{

    private Long id;
    
    private String firstName;
    private String lastName;
    private Posts post;
    private String login;
    private String password;
    private DateTime employmentDate;
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Имя
     * @return 
     */
    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * Фамилия
     * @return 
     */
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Должность
     * @return 
     */
    @Column(name = "POST")
    @Enumerated(EnumType.STRING)
    public Posts getPost() {
        return post;
    }

    public void setPost(Posts post) {
        this.post = post;
    }

    /**
     * Логин
     * @return 
     */
    @Column(name = "LOGIN")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Пароль
     * @return 
     */
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Дата принятия на работу
     * @return 
     */
    @Column(name = "EMPLOYMENT_DATE")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(DateTime employmentDate) {
        this.employmentDate = employmentDate;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
    
    

    
    
    
    
}
