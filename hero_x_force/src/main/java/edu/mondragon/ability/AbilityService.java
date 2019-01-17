/**
 * @file AbilityService.java
 * @brief The ability service class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.model
 */

package edu.mondragon.ability;

import java.util.List;

public interface AbilityService {
	/**
	 * @brief Method o add an ability
	 * @param ability Ability object
	 * @return void
	 */
	void addAbility(Ability ability);

	/**
	 * @brief Method to obtain the abilities list
	 * @return List<Ability>
	 */
	List<Ability> listAbilities();

	/**
	 * @brief Method to get an ability
	 * @param abilityId Ability id int
	 * @return Ability
	 */
	Ability getAbilityById(int abilityId);
}