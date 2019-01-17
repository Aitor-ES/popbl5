/**
 * @file EmailService.java
 * @brief The email service interface
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.email
 */

package edu.mondragon.email;

public interface EmailService {
	/**
	 * @brief This method the sends a email
	 * @param to To string
	 * @param subject Subject string
	 * @param text Text string
	 * @return void
	 */
	void sendSimpleMessage(String to, String subject, String text);
}