/**
 * @file AbilityserviceImp.java
 * @brief Class to manage the ability dao
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 13/11/2018
 * @brief Package edu.mondragon.ability
 */

package edu.mondragon.ability;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AbilityServiceImp implements AbilityService {

	/**
	 * @brief ability dao object
	 */
	@Autowired
	private AbilityDao abilityDao;

	/**
	 * @brief Method to add abilities to the dao
	 * @param ability Ability object
	 * @return void
	 */
	@Transactional
	@Override
	public void addAbility(Ability ability) {
		abilityDao.addAbility(ability);
	}
	
	/**
	 * @brief Method to obtain the abilities from the dao
	 * @return List<Ability>
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Ability> listAbilities() {
		return abilityDao.listAbilities();
	}
	
	/**
	 * @brief Method to obtain the ability using the id from the dao
	 * @param abilityId Ability id int
	 * @return Ability
	 */
	@Transactional(readOnly = true)
	@Override
	public Ability getAbilityById(int abilityId) {
		return abilityDao.getAbilityById(abilityId);
	}
}