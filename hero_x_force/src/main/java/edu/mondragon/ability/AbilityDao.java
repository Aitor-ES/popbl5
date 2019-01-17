/**
 * @file AbilityDao.java
 * @brief The ability dao class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.ability
 */
package edu.mondragon.ability;

import java.util.List;

public interface AbilityDao {
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
