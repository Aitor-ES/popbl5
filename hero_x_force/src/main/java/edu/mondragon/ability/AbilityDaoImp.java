/**
 * @file AbilityDaoImp.java
 * @brief The ability dao implementation class
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.ability
 */package edu.mondragon.ability;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AbilityDaoImp implements AbilityDao {

	/**
	 * @brief The session factory
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @brief This method adds an ability
	 * @param ability Ability object
	 * @return void
	 */
	@Override
	public void addAbility(Ability ability) {
		getCurrentSession().save(ability);
	}

	/**
	 * @brief Method to obtain the list of abilities that are in database
	 * @return List<Ability>
	 */
	@Override
	public List<Ability> listAbilities() {
		@SuppressWarnings("unchecked")
		TypedQuery<Ability> query = getCurrentSession().createQuery("FROM Ability");
		return query.getResultList();
	}

	/**
	 * @brief Method to find a ability using the id
	 * @param abilityId Ability id
	 * @return Ability
	 */
	@Override
	public Ability getAbilityById(int abilityId) {
		Ability ability = getCurrentSession().find(Ability.class, abilityId);
		return ability;
	}

	/**
	 * @brief Method to obtain the current session
	 * @return Session
	 */
	protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}