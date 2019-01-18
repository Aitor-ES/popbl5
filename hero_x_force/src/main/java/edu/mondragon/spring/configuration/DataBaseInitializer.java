/**
 * @file DataBaseInitializer.java
 * @brief Class to initialize the data base and insert initial values
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

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.mondragon.ability.Ability;
import edu.mondragon.ability.AbilityService;
import edu.mondragon.achievement.Achievement;
import edu.mondragon.achievement.AchievementService;
import edu.mondragon.card.Card;
import edu.mondragon.card.CardService;
import edu.mondragon.user.User;
import edu.mondragon.user.UserService;

public class DataBaseInitializer {

	/**
	 * @brief The session factory
	 */
	private AnnotationConfigApplicationContext context;

	/**
	 * @brief Method to insert all the initial values in the DB
	 * @param context AnnotationConfigApplicationContext object
	 */
	public DataBaseInitializer(AnnotationConfigApplicationContext context) {
		this.context = context;

		Properties properties = new Properties();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			properties.load(classLoader.getResourceAsStream("db.properties"));

			if (Boolean.valueOf(properties.getProperty("hxf.hibernate.insert"))) {
				insertValuesInDB();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @brief Method to insert values in data base
	 * @return void
	 */
	private void insertValuesInDB() {
		/* 1. USER INSERTS */
		UserService userService = context.getBean(UserService.class);

		User user1 = new User("estarrona", "aitor.estarrona@alumni.mondragon.edu", "@Root1234");
		userService.addUser(user1);

		User user2 = new User("uribarren", "julen.uribarren@alumni.mondragon.edu", "@Root1234");
		userService.addUser(user2);

		User user3 = new User("mendi", "iker.mendi@alumni.mondragon.edu", "@Root1234");
		userService.addUser(user3);

		User user4 = new User("barreiro", "aitor.barreirom@alumni.mondragon.edu", "@Root1234");
		userService.addUser(user4);

		/* 2. ACHIEVEMENT INSERTS */
		AchievementService achievementService = context.getBean(AchievementService.class);

		Achievement achievement1 = new Achievement("Recruit", 10, "Win 5 battles");
		achievementService.addAchievement(achievement1);

		Achievement achievement2 = new Achievement("Cadet", 20, "Win 10 battles");
		achievementService.addAchievement(achievement2);

		Achievement achievement3 = new Achievement("Sergeant", 50, "Win 20 battles");
		achievementService.addAchievement(achievement3);

		Achievement achievement4 = new Achievement("Lieutenant", 100, "Win 50 battles");
		achievementService.addAchievement(achievement4);

		Achievement achievement5 = new Achievement("Captain", 200, "Win 100 battles");
		achievementService.addAchievement(achievement5);

		Achievement achievement6 = new Achievement("Colonel", 300, "Win 150 battles");
		achievementService.addAchievement(achievement6);

		Achievement achievement7 = new Achievement("General", 500, "Win 200 battles");
		achievementService.addAchievement(achievement7);

		/* 3. ABILITY INSERTS */
		AbilityService abilityService = context.getBean(AbilityService.class);

		Ability ability1 = new Ability("Lightning Rod", "Electric attacks deal 50% less damage.");
		abilityService.addAbility(ability1);

		Ability ability2 = new Ability("Soul Siphon", "Heals for the magic damage dealt to other heroes.");
		abilityService.addAbility(ability2);

		Ability ability3 = new Ability("Battle Fury",
				"Deals more damage if the hero also attacked in the previous turn.");
		abilityService.addAbility(ability3);

		Ability ability4 = new Ability("Illumination",
				"Deals much more damage if the hero also attacked the same enemy in the previous turn.");
		abilityService.addAbility(ability4);

		Ability ability5 = new Ability("Backstab",
				"Deals much more damage if the hero attacks an enemy who is attacking another hero in that turn.");
		abilityService.addAbility(ability5);

		Ability ability6 = new Ability("Traveler's Call",
				"Defending causes magical spirits to appear. They increase Magic Attack and Speed and gain more power with time.");
		abilityService.addAbility(ability6);

		Ability ability7 = new Ability("Monado Foresight",
				"The team knows the next move of the enemy before choosing its own move.");
		abilityService.addAbility(ability7);

		Ability ability8 = new Ability("Triforce of Courage",
				"Increases all stats when another team member gets defeated.");
		abilityService.addAbility(ability8);

		Ability ability9 = new Ability("Triforce of Wisdom", "All team members get increased defense.");
		abilityService.addAbility(ability9);

		Ability ability10 = new Ability("Triforce of Power",
				"Starts with a buff on Attack and Magic Attack that loses power with damage.");
		abilityService.addAbility(ability10);

		Ability ability11 = new Ability("Pressure", "The enemy team cannot do the same attack twice in a row.");
		abilityService.addAbility(ability11);

		Ability ability12 = new Ability("Overgrow", "Plant-type moves deal more damage when low HP.");
		abilityService.addAbility(ability12);

		Ability ability13 = new Ability("Heart of Justice", "Raises Attack when hit by a Dark-type move.");
		abilityService.addAbility(ability13);

		Ability ability14 = new Ability("Thick Fat", "Gives more resistance to Fire and Ice moves.");
		abilityService.addAbility(ability14);

		Ability ability15 = new Ability("Bad Time", "Gives 95% chance of dodging attacks in each turn.");
		abilityService.addAbility(ability15);

		Ability ability16 = new Ability("Spear of Justice",
				"Can transform into Undyne the Undying when defeated if there is still an ally in the battle.");
		abilityService.addAbility(ability16);

		Ability ability17 = new Ability("True Heroine",
				"Gets increased stats while there is still an ally in the battle.");
		abilityService.addAbility(ability17);

		Ability ability18 = new Ability("D6", "Gets random stats changes during the battle.");
		abilityService.addAbility(ability18);

		Ability ability19 = new Ability("Holy Mantle",
				"Automatically negates one hit of damage. It recovers after the end of the next turn.");
		abilityService.addAbility(ability19);

		Ability ability20 = new Ability("Dimensional Tears",
				"Gets random health recovers or stat increases during the battle. Can randomly dodge attacks.");
		abilityService.addAbility(ability20);

		/* 4. CARD INSERTS */
		CardService cardService = context.getBean(CardService.class);

		Card card1 = new Card("Pikachu", "Pokémon", "static/img/card/heroes/Pikachu.png", "Pikachu image", "Electric",
				ability1, 60, 90, 55, 90, 80, 110, 2);
		cardService.addCard(card1);

		Card card2 = new Card("Rotom", "Pokémon", "static/img/card/heroes/Rotom.png", "Rotom image", "Electric",
				ability1, 50, 50, 77, 95, 77, 91, 1);
		cardService.addCard(card2);

		Card card3 = new Card("Morgana", "League of Legends", "static/img/card/heroes/Morgana.png", "Morgana image",
				"Dark", ability2, 70, 90, 90, 135, 90, 125, 4);
		cardService.addCard(card3);

		Card card4 = new Card("Tryndamere", "League of Legends", "static/img/card/heroes/Tryndamere.png",
				"Tryndamere image", "Ice", ability3, 110, 130, 80, 70, 60, 80, 3);
		cardService.addCard(card4);

		Card card5 = new Card("Lux", "League of Legends", "static/img/card/heroes/Lux.png", "Lux image", "Light",
				ability4, 68, 65, 65, 125, 115, 80, 3);
		cardService.addCard(card5);

		Card card6 = new Card("Shaco", "League of Legends", "static/img/card/heroes/Shaco.png", "Shaco image", "Dark",
				ability5, 95, 103, 67, 72, 71, 122, 3);
		cardService.addCard(card6);

		Card card7 = new Card("Bard", "League of Legends", "static/img/card/heroes/Bard.png", "Bard image", "Light",
				ability6, 85, 50, 120, 95, 115, 80, 3);
		cardService.addCard(card7);

		Card card8 = new Card("Shulk", "Xenoblade Chronicles", "static/img/card/heroes/Shulk.png", "Shulk image",
				"Light", ability7, 70, 140, 88, 145, 70, 112, 5);
		cardService.addCard(card8);

		Card card9 = new Card("Link", "The Legend of Zelda", "static/img/card/heroes/Link.png", "Link image", "Light",
				ability8, 108, 130, 95, 80, 85, 102, 4);
		cardService.addCard(card9);

		Card card10 = new Card("Zelda", "The Legend of Zelda", "static/img/card/heroes/Zelda.png", "Zelda image",
				"Light", ability9, 95, 65, 130, 115, 130, 65, 4);
		cardService.addCard(card10);

		Card card11 = new Card("Ganondorf", "The Legend of Zelda", "static/img/card/heroes/Ganondorf.png",
				"Ganondorf image", "Dark", ability10, 100, 134, 110, 95, 100, 61, 4);
		cardService.addCard(card11);

		Card card12 = new Card("Mewtwo", "Pokémon", "static/img/card/heroes/Mewtwo.png", "Mewtwo image", "Psychic",
				ability11, 106, 110, 90, 154, 90, 130, 5);
		cardService.addCard(card12);

		Card card13 = new Card("Bulbasaur", "Pokémon", "static/img/card/heroes/Bulbasaur.png", "Bulbasaur image",
				"Plant", ability12, 60, 62, 63, 80, 80, 60, 1);
		cardService.addCard(card13);

		Card card14 = new Card("Arcanine", "Pokémon", "static/img/card/heroes/Arcanine.png", "Arcanine image", "Fire",
				ability13, 90, 110, 80, 100, 80, 95, 4);
		cardService.addCard(card14);

		Card card15 = new Card("Snorlax", "Pokémon", "static/img/card/heroes/Snorlax.png", "Snorlax image", "Normal",
				ability14, 160, 110, 65, 65, 110, 30, 4);
		cardService.addCard(card15);

		Card card16 = new Card("Sans", "Undertale", "static/img/card/heroes/Sans.png", "Sans image", "Dark", ability15,
				1, 200, 1, 200, 1, 200, 5);
		cardService.addCard(card16);

		Card card17 = new Card("Undyne", "Undertale", "static/img/card/heroes/Undyne.png", "Undyne image", "Water",
				ability15, 95, 108, 70, 100, 70, 85, 3);
		cardService.addCard(card17);

		Card card18 = new Card("Undyne the Undying", "Undertale", "static/img/card/heroes/Undyne the Undying.png",
				"Undyne the Undying image", "Water", ability16, 105, 158, 80, 120, 80, 100, 5);
		cardService.addCard(card18);

		Card card19 = new Card("Isaac", "The Binding of Isaac", "static/img/card/heroes/Isaac.png", "Isaac image",
				"Normal", ability17, 90, 90, 90, 90, 90, 90, 4);
		cardService.addCard(card19);

		Card card20 = new Card("The Lost", "The Binding of Isaac", "static/img/card/heroes/The Lost.png",
				"The Lost image", "Ghost", ability18, -1, 90, 90, 90, 90, 90, 4);
		cardService.addCard(card20);

		Card card21 = new Card("Subject Delta", "Bioshock", "static/img/card/heroes/Subject Delta.png",
				"Undyne the Undying image", "Normal", ability19, 100, 90, 105, 80, 100, 60, 3);
		cardService.addCard(card21);

		Card card22 = new Card("Booker DeWitt and Elizabeth", "Bioshock",
				"static/img/card/heroes/Booker DeWitt and Elizabeth.png", "Booker DeWitt and Elizabeth image", "Normal",
				ability20, 80, 125, 75, 120, 75, 90, 4);
		cardService.addCard(card22);

		/* 5. DECK INSERTS */
		// NONE

		/* 6. TOURNAMENT INSERTS */
		// NONE

		/* 7. MATCH INSERTS */
		// NONE
	}
}
