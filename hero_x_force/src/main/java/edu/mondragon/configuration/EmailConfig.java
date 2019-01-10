package edu.mondragon.configuration;

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
@ComponentScan(basePackages = "edu.mondragon.service")
public class EmailConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
    public SimpleMailMessage templateSimpleMessage() {
	    SimpleMailMessage message = new SimpleMailMessage();
	    message.setText("This is the test email template for your email:\n%s\n");
	    return message;
	}
	
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
