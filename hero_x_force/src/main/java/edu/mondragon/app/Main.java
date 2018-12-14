/**
 * @file Main.java
 * @brief This is the main class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.app
 */

package edu.mondragon.app;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.mondragon.configuration.HibernateApplicationConfiguration;
import edu.mondragon.model.User;
import edu.mondragon.service.UserService;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				HibernateApplicationConfiguration.class);

		UserService userService = context.getBean(UserService.class);

		// Add Users
		/*userService.add(new User("Sunil", "Bora", "suni.bora@example.com", "1234"));
		userService.add(new User("David", "Miller", "david.miller@example.com", "1234"));
		userService.add(new User("Sameer", "Singh", "sameer.singh@example.com", "1234"));
		userService.add(new User("Paul", "Smith", "paul.smith@example.com", "1234"));*/

		// Get Users
		List<User> users = userService.listUsers();
		for (User user : users) {
			System.out.println("Id = " + user.getId());
			System.out.println("First Name = " + user.getFirstName());
			System.out.println("Last Name = " + user.getLastName());
			System.out.println("Email = " + user.getEmail());
			System.out.println("Password = " + user.getPassword());
			System.out.println();
		}
		
		User user = userService.getUserByName("Sameer");
		System.out.println("Id = " + user.getId());
		System.out.println("First Name = " + user.getFirstName());
		System.out.println("Last Name = " + user.getLastName());
		System.out.println("Email = " + user.getEmail());
		System.out.println("Password = " + user.getPassword());
		System.out.println();

		context.close();
	}

}
