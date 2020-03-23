package com.medical.shop.management.system.MedicalManagemnt.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.medical.shop.management.system.Medical.Managment.Dao.UserDao;
import com.medical.shop.management.system.Medical.Managment.Dao.UserDaoImpl;

@Configuration
public class DBConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// MySQL database we are using
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/medical_shop");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}

	/*@Bean
	public JavaMailSender javaMailService() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setHost("smtp.gmail.com");
		javaMailSender.setPort(587);
		javaMailSender.setUsername("ashvanijaiswal7897@gmail.com");
		javaMailSender.setPassword("@9307638130");
		javaMailSender.setJavaMailProperties(getMailProperties());
		return javaMailSender;
	}

	*//**
	 * Property setters for mail
	 * 
	 *//*
	private Properties getMailProperties() {
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.debug", "true");
		return properties;
	}
*/
	@Bean
	public UserDao UserDAO() {
		UserDaoImpl user = new UserDaoImpl();
		user.setJdbcTemplate(jdbcTemplate());
		return user;
	}
}
