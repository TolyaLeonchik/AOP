package com.site.annotation;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AspectTestingClass {

    public void printTesting() {
        System.out.println("Testing...");
    }

    public int calculating() {
        return 20;
    }

    public String dataToday() {
        return (LocalDate.now().toString());
    }
}
