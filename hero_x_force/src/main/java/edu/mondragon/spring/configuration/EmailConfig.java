/**
 * @file EmailConfig.java
 * @brief Email configuration class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.spring.configuration
 */
package edu.mondragon.spring.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@PropertySource("classpath:mail.properties")
@ComponentScan(basePackages = "edu.mondragon.email")
public class EmailConfig {
	
	/**
	 * @brief env Interface representing the environment in which the current application is running
	 */
	@Autowired
	private Environment env;
	
	/**
	 * @brief Create simple email message
	 * @return SimpleEmailMessage
	 */
	@Bean
    public SimpleMailMessage templateSimpleMessage() {
	    SimpleMailMessage message = new SimpleMailMessage();
	    message.setText("This is the test email template for your email:\n%s\n");
	    return message;
	}
	
	/**
	 * @brief Method to get the JavaMailSender
	 * @return JavaMailSender
	 */
	@Bean
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost(env.getProperty("spring.mail.host"));
	    mailSender.setPort(Integer.parseInt(env.getProperty("spring.mail.port")));
	    mailSender.setUsername(env.getProperty("spring.mail.username"));
	    mailSender.setPassword(env.getProperty("spring.mail.password"));
	    
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", env.getProperty("spring.mail.transport.protocol"));
	    props.put("mail.smtp.auth", env.getProperty("spring.mail.smtp.auth"));
	    props.put("mail.smtp.socketFactory.class", env.getProperty("spring.mail.smtp.socketFactory.class"));
	    props.put("mail.debug", env.getProperty("spring.mail.debug"));
	    
	    return mailSender;
	}
}
