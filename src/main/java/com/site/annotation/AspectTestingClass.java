package com.site.annotation;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AspectTestingClass {

    public void printTesting() {
        System.out.println("Testing...");
    }

    public Integer calculating() {
        int x = 10;
        int y = 20;
        return (x * y / (y - x));
    }

    public String dataToday() {
        return (LocalDate.now().toString());
    }
}
