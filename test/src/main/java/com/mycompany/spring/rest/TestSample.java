package com.mycompany.spring.rest;

import org.joda.time.DateTime;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

/**
 * Класс проверки работы REST служб
 * @author kamalion
 */
public class TestSample {
    private static final String URL_GET_ALL_HOLIDAYS =
            "http://localhost:8080/test/restful/holiday/listholiday";
    private static final String URL_GET_HOLIDAY_BY_ID =
            "http://localhost:8080/test/restful/holiday/{id}";
    private static final String URL_CREATE_HOLIDAY =
            "http://localhost:8080/test/restful/holiday/";
    private static final String URL_UPDATE_HOLIDAY =
            "http://localhost:8080/test/restful/holiday/{id}";
    private static final String URL_DELETE_HOLIDAY =
            "http://localhost:8080/test/restful/holiday/{id}";

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/restful-client-app-context.xml");
        ctx.refresh();

        Holiday holiday;
        RestTemplate restTemplate = ctx.getBean("restTemplate", RestTemplate.class);

        System.out.println("Testing retrieve all holidays:");
        Holidays holidays = restTemplate.getForObject(URL_GET_ALL_HOLIDAYS, Holidays.class);
        listHolidays(holidays);

        System.out.println("Testing retrieve a holiday by id :");
        holiday = restTemplate.getForObject(URL_GET_HOLIDAY_BY_ID, Holiday.class, 1);
        System.out.println(holiday);
        System.out.println("");

        holiday = restTemplate.getForObject(URL_UPDATE_HOLIDAY, Holiday.class, 1);
        holiday.setDuration(18);
        System.out.println("Testing update holiday by id :");
        restTemplate.put(URL_UPDATE_HOLIDAY, holiday, 1);
        System.out.println("Holiday update successfully: " + holiday);
        System.out.println("");

        restTemplate.delete(URL_DELETE_HOLIDAY, 1);
        System.out.println("Testing delete holiday by id :");
        holidays = restTemplate.getForObject(URL_GET_ALL_HOLIDAYS, Holidays.class);
        listHolidays(holidays);

        System.out.println("Testing create holiday :");
        Holiday holidayNew = new Holiday();
        holidayNew.setDateBegin(new DateTime());
        holidayNew.setDuration(20);
        holidayNew.setStatus(Statuses.DRAFT);
        
        User user = new User();
        user.setFirstName("Petr");
        user.setLastName("Nereev");
        user.setLogin("yr");
        user.setPassword("111");
        user.setPost(Posts.USER);
        user.setEmploymentDate(new DateTime());
        
        holidayNew.setUser(user);
        holidayNew = restTemplate.postForObject(URL_CREATE_HOLIDAY, holidayNew, Holiday.class);
        System.out.println("Holiday created successfully: " + holidayNew);
    }

    private static void listHolidays(Holidays holidays) {
        for (Holiday holiday: holidays.getHolidays()) {
            System.out.println(holiday);
        }

        System.out.println("");
    }
}
