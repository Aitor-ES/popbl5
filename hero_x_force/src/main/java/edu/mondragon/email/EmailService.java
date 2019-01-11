package edu.mondragon.email;

public interface EmailService {
	void sendSimpleMessage(String to, String subject, String text);
}