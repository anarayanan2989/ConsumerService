package com.egen.challenge.ConsumerService;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
@EnableDiscoveryClient
public class App 
{
	
    public static void main( String[] args )
    {
       ApplicationContext ctx = SpringApplication.run(App.class, args);
       String[] beanNames = ctx.getBeanDefinitionNames();
       Arrays.sort(beanNames);
       for (String beanName : beanNames) {
           System.out.println(beanName);
       }
       
    }
    
    
}
