package com.site;

import com.site.annotation.AspectTestingClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@ComponentScan("com.site")
public class SpringStart {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringStart.class);

        AspectTestingClass aspectTestingClass = context.getBean("aspectTestingClass", AspectTestingClass.class);
        aspectTestingClass.calculating();
        aspectTestingClass.printTesting();
        aspectTestingClass.dataToday();
    }
}
