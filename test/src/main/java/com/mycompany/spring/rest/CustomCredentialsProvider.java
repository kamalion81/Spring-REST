package com.mycompany.spring.rest;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.impl.client.BasicCredentialsProvider;

/**
 * Класс предоставления учетных данных
 * @author kamalion
 */
public class CustomCredentialsProvider extends BasicCredentialsProvider {

    /**
     * Устанавливает учетные данные в конфигурацию
     * @param credentials 
     */
    public void setCredentials(Credentials credentials) {
        this.setCredentials(AuthScope.ANY, credentials);
    }
}
