package guru.springframework.sfgdi.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by jt on 12/27/19.
 */
@Primary
@Service
public class PrimaryGreetingService implements GreetingService, InitializingBean, DisposableBean, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware {

    public PrimaryGreetingService() {
        System.out.println("## I'm in the PrimaryGreetingService Constructor");
    }

    @Override
    public String sayGreeting() {
        return "Hello World - From the PRIMARY Bean";
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("## The PrimaryGreetingService bean has been terminated");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## The PrimaryGreetingService has its properties set!");

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## Bean Factory has been set to PrimaryGreetingService");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("## My Bean Name is: " + name);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## Application context has been set to PrimaryGreetingService");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("## The Post Construct annotated method has been called for PrimaryGreetingService");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("## The Predestroy annotated method has been called");
    }

    public void beforeInit(){
        System.out.println("## - Before Init PrimaryGreetingService - Called by Bean Post Processor");
    }

    public void afterInit(){
        System.out.println("## - After Init PrimaryGreetingService - Called by Bean Post Processor");
    }
}
