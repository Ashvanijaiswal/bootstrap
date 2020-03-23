package com.medical.shop.management.system.Medical.Managment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.medical.shop.management.system.MedicalManagemnt.Config.DBConfig;


@SpringBootApplication(scanBasePackages={"com.medical.shop.management"})
public class MedicalManagmentApplication  {
	public static void main(String[] args) {
		SpringApplication.run(MedicalManagmentApplication.class, args);
		System.out.println("working");
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DBConfig.class);
		System.out.println(applicationContext);//AnnotationConfigApplicationContext applicationContext1 = new AnnotationConfigApplicationContext(MailConfiguration.class);
	}
	 
}
