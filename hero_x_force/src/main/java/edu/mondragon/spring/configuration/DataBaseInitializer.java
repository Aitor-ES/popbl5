/**
 * @file DataBaseInitializer.java
 * @brief Class to initialize the data base
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
	 * @brief Class constructor
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

		User user_1 = new User("estarrona", "aitor.estarrona@alumni.mondragon.edu", "@Root1234");
		userService.addUser(user_1);
		
		User user_2 = new User("uribarren", "julen.uribarren@alumni.mondragon.edu", "@Root1234");
		userService.addUser(user_2);
		
		User user_3 = new User("mendi", "iker.mendi@alumni.mondragon.edu", "@Root1234");
		userService.addUser(user_3);
		
		User user_4 = new User("barreiro", "aitor.barreirom@alumni.mondragon.edu", "@Root1234");
		userService.addUser(user_4);

		/* 2. ACHIEVEMENT INSERTS */
		AchievementService achievementService = context.getBean(AchievementService.class);
		
		Achievement achievement_1 = new Achievement("Recruit", 10, "Win 5 battles");
		achievementService.addAchievement(achievement_1);
		
		Achievement achievement_2 = new Achievement("Cadet", 20, "Win 10 battles");
		achievementService.addAchievement(achievement_2);
		
		Achievement achievement_3 = new Achievement("Sergeant", 50, "Win 20 battles");
		achievementService.addAchievement(achievement_3);
		
		Achievement achievement_4 = new Achievement("Lieutenant", 100, "Win 50 battles");
		achievementService.addAchievement(achievement_4);
		
		Achievement achievement_5 = new Achievement("Captain", 200, "Win 100 battles");
		achievementService.addAchievement(achievement_5);
		
		Achievement achievement_6 = new Achievement("Colonel", 300, "Win 150 battles");
		achievementService.addAchievement(achievement_6);
		
		Achievement achievement_7 = new Achievement("General", 500, "Win 200 battles");
		achievementService.addAchievement(achievement_7);

		/* 3. ABILITY INSERTS */
		AbilityService abilityService = context.getBean(AbilityService.class);

		Ability ability_1 = new Ability("Lightning Rod", "Electric attacks deal 50% less damage.");
		abilityService.addAbility(ability_1);

		Ability ability_2 = new Ability("Soul Siphon", "Heals for the magic damage dealt to other heroes.");
		abilityService.addAbility(ability_2);

		Ability ability_3 = new Ability("Battle Fury",
				"Deals more damage if the hero also attacked in the previous turn.");
		abilityService.addAbility(ability_3);

		Ability ability_4 = new Ability("Illumination",
				"Deals much more damage if the hero also attacked the same enemy in the previous turn.");
		abilityService.addAbility(ability_4);

		Ability ability_5 = new Ability("Backstab",
				"Deals much more damage if the hero attacks an enemy who is attacking another hero in that turn.");
		abilityService.addAbility(ability_5);

		Ability ability_6 = new Ability("Traveler's Call",
				"Defending causes magical spirits to appear. They increase Magic Attack and Speed and gain more power with time.");
		abilityService.addAbility(ability_6);

		Ability ability_7 = new Ability("Monado Foresight",
				"The team knows the next move of the enemy before choosing its own move.");
		abilityService.addAbility(ability_7);

		Ability ability_8 = new Ability("Triforce of Courage",
				"Increases all stats when another team member gets defeated.");
		abilityService.addAbility(ability_8);

		Ability ability_9 = new Ability("Triforce of Wisdom", "All team members get increased defense.");
		abilityService.addAbility(ability_9);

		Ability ability_10 = new Ability("Triforce of Power",
				"Starts with a buff on Attack and Magic Attack that loses power with damage.");
		abilityService.addAbility(ability_10);

		Ability ability_11 = new Ability("Pressure", "The enemy team can\\'t do the same attack twice in a row.");
		abilityService.addAbility(ability_11);

		Ability ability_12 = new Ability("Overgrow", "Plant-type moves deal more damage when low HP.");
		abilityService.addAbility(ability_12);

		Ability ability_13 = new Ability("Heart of Justice", "Raises Attack when hit by a Dark-type move.");
		abilityService.addAbility(ability_13);

		Ability ability_14 = new Ability("Thick Fat", "Gives more resistance to Fire and Ice moves.");
		abilityService.addAbility(ability_14);

		Ability ability_15 = new Ability("Bad Time", "Gives 95% chance of dodging attacks in each turn.");
		abilityService.addAbility(ability_15);

		Ability ability_16 = new Ability("Spear of Justice",
				"Can transform into Undyne the Undying when defeated if there is still an ally in the battle.");
		abilityService.addAbility(ability_16);

		Ability ability_17 = new Ability("True Heroine",
				"Gets increased stats while there is still an ally in the battle.");
		abilityService.addAbility(ability_17);

		Ability ability_18 = new Ability("D6", "Gets random stats changes during the battle.");
		abilityService.addAbility(ability_18);

		Ability ability_19 = new Ability("Holy Mantle",
				"Automatically negates one hit of damage. It recovers after the end of the next turn.");
		abilityService.addAbility(ability_19);

		Ability ability_20 = new Ability("Dimensional Tears",
				"Gets random health recovers or stat increases during the battle. Can randomly dodge attacks.");
		abilityService.addAbility(ability_20);

		/* 4. CARD INSERTS */
		CardService cardService = context.getBean(CardService.class);

		Card card_1 = new Card("Pikachu", "Pokémon",
				"http://los40cr00.epimg.net/los40/imagenes/2018/12/03/actualidad/1543857937_704979_1543858004_noticia_normal.jpg",
				"Pikachu image", "Electric", ability_1, 60, 90, 55, 90, 80, 110, 2);
		cardService.addCard(card_1);

		Card card_2 = new Card("Rotom", "Pokémon",
				"http://los40cr00.epimg.net/los40/imagenes/2018/12/03/actualidad/1543857937_704979_1543858004_noticia_normal.jpg",
				"Rotom image", "Electric", ability_1, 50, 50, 77, 95, 77, 91, 1);
		cardService.addCard(card_2);

		Card card_3 = new Card("Morgana", "League of Legends",
				"http://los40cr00.epimg.net/los40/imagenes/2018/12/03/actualidad/1543857937_704979_1543858004_noticia_normal.jpg",
				"Morgana image", "Dark", ability_2, 70, 90, 90, 135, 90, 125, 4);
		cardService.addCard(card_3);

		Card card_4 = new Card("Tryndamere", "League of Legends",
				"http://los40cr00.epimg.net/los40/imagenes/2018/12/03/actualidad/1543857937_704979_1543858004_noticia_normal.jpg",
				"Tryndamere image", "Ice", ability_3, 110, 130, 80, 70, 60, 80, 3);
		cardService.addCard(card_4);

		Card card_5 = new Card("Lux", "League of Legends",
				"http://los40cr00.epimg.net/los40/imagenes/2018/12/03/actualidad/1543857937_704979_1543858004_noticia_normal.jpg",
				"Lux image", "Light", ability_4, 68, 65, 65, 125, 115, 80, 3);
		cardService.addCard(card_5);

		Card card_6 = new Card("Shaco", "League of Legends",
				"http://los40cr00.epimg.net/los40/imagenes/2018/12/03/actualidad/1543857937_704979_1543858004_noticia_normal.jpg",
				"Shaco image", "Dark", ability_5, 95, 103, 67, 72, 71, 122, 3);
		cardService.addCard(card_6);

		Card card_7 = new Card("Bard", "League of Legends",
				"http://los40cr00.epimg.net/los40/imagenes/2018/12/03/actualidad/1543857937_704979_1543858004_noticia_normal.jpg",
				"Bard image", "Light", ability_6, 85, 50, 120, 95, 115, 80, 3);
		cardService.addCard(card_7);

		Card card_8 = new Card("Shulk", "Xenoblade Chronicles",
				"http://los40cr00.epimg.net/los40/imagenes/2018/12/03/actualidad/1543857937_704979_1543858004_noticia_normal.jpg",
				"Shulk image", "Light", ability_7, 70, 140, 88, 145, 70, 112, 5);
		cardService.addCard(card_8);

		Card card_9 = new Card("Link", "The Legend of Zelda",
				"http://los40cr00.epimg.net/los40/imagenes/2018/12/03/actualidad/1543857937_704979_1543858004_noticia_normal.jpg",
				"Link image", "Light", ability_8, 108, 130, 95, 80, 85, 102, 4);
		cardService.addCard(card_9);

		Card card_10 = new Card("Zelda", "The Legend of Zelda",
				"http://los40cr00.epimg.net/los40/imagenes/2018/12/03/actualidad/1543857937_704979_1543858004_noticia_normal.jpg",
				"Zelda image", "Light", ability_9, 95, 65, 130, 115, 130, 65, 4);
		cardService.addCard(card_10);

		Card card_11 = new Card("Ganondorf", "The Legend of Zelda",
				"http://los40cr00.epimg.net/los40/imagenes/2018/12/03/actualidad/1543857937_704979_1543858004_noticia_normal.jpg",
				"Ganondorf image", "Dark", ability_10, 100, 134, 110, 95, 100, 61, 4);
		cardService.addCard(card_11);

		Card card_12 = new Card("Mewtwo", "Pokémon",
				"http://los40cr00.epimg.net/los40/imagenes/2018/12/03/actualidad/1543857937_704979_1543858004_noticia_normal.jpg",
				"Mewtwo image", "Psychic", ability_11, 106, 110, 90, 154, 90, 130, 5);
		cardService.addCard(card_12);

		Card card_13 = new Card("Bulbasaur", "Pokémon",
				"http://los40cr00.epimg.net/los40/imagenes/2018/12/03/actualidad/1543857937_704979_1543858004_noticia_normal.jpg",
				"Bulbasaur image", "Plant", ability_12, 60, 62, 63, 80, 80, 60, 1);
		cardService.addCard(card_13);

		Card card_14 = new Card("Arcanine", "Pokémon",
				"http://los40cr00.epimg.net/los40/imagenes/2018/12/03/actualidad/1543857937_704979_1543858004_noticia_normal.jpg",
				"Arcanine image", "Fire", ability_13, 90, 110, 80, 100, 80, 95, 4);
		cardService.addCard(card_14);

		Card card_15 = new Card("Snorlax", "Pokémon",
				"http://los40cr00.epimg.net/los40/imagenes/2018/12/03/actualidad/1543857937_704979_1543858004_noticia_normal.jpg",
				"Snorlax image", "Normal", ability_14, 160, 110, 65, 65, 110, 30, 4);
		cardService.addCard(card_15);

		Card card_16 = new Card("Sans", "Undertale",
				"http://los40cr00.epimg.net/los40/imagenes/2018/12/03/actualidad/1543857937_704979_1543858004_noticia_normal.jpg",
				"Sans image", "Dark", ability_15, 1, 200, 1, 200, 1, 200, 5);
		cardService.addCard(card_16);

		Card card_17 = new Card("Undyne", "Undertale",
				"http://los40cr00.epimg.net/los40/imagenes/2018/12/03/actualidad/1543857937_704979_1543858004_noticia_normal.jpg",
				"Undyne image", "Water", ability_15, 95, 108, 70, 100, 70, 85, 3);
		cardService.addCard(card_17);

		Card card_18 = new Card("Undyne the Undying", "Undertale",
				"http://los40cr00.epimg.net/los40/imagenes/2018/12/03/actualidad/1543857937_704979_1543858004_noticia_normal.jpg",
				"Undyne the Undying image", "Water", ability_16, 105, 158, 80, 120, 80, 100, 5);
		cardService.addCard(card_18);

		Card card_19 = new Card("Isaac", "The Binding of Isaac",
				"http://los40cr00.epimg.net/los40/imagenes/2018/12/03/actualidad/1543857937_704979_1543858004_noticia_normal.jpg",
				"Isaac image", "Normal", ability_17, 90, 90, 90, 90, 90, 90, 4);
		cardService.addCard(card_19);

		Card card_20 = new Card("The Lost", "The Binding of Isaac",
				"http://los40cr00.epimg.net/los40/imagenes/2018/12/03/actualidad/1543857937_704979_1543858004_noticia_normal.jpg",
				"The Lost image", "Ghost", ability_18, -1, 90, 90, 90, 90, 90, 4);
		cardService.addCard(card_20);

		Card card_21 = new Card("Subject Delta", "Bioshock",
				"http://los40cr00.epimg.net/los40/imagenes/2018/12/03/actualidad/1543857937_704979_1543858004_noticia_normal.jpg",
				"Undyne the Undying image", "Normal", ability_19, 100, 90, 105, 80, 100, 60, 3);
		cardService.addCard(card_21);

		Card card_22 = new Card("Booker DeWitt and Elizabeth", "Bioshock",
				"http://los40cr00.epimg.net/los40/imagenes/2018/12/03/actualidad/1543857937_704979_1543858004_noticia_normal.jpg",
				"Booker DeWitt and Elizabeth image", "Normal", ability_20, 80, 125, 75, 120, 75, 90, 4);
		cardService.addCard(card_22);

		/* 5. DECK INSERTS */
		// NONE

		/* 6. TOURNAMENT INSERTS */
		// NONE

		/* 7. MATCH INSERTS */
		// NONE
	}
}
