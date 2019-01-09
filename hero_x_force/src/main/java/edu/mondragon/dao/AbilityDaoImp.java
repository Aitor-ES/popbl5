package edu.mondragon.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mondragon.model.Ability;

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
	 * @param id Ability id
	 * @return Ability
	 */
	@Override
	public Ability getAbilityById(int ability_id) {
		Ability ability = getCurrentSession().find(Ability.class, ability_id);
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