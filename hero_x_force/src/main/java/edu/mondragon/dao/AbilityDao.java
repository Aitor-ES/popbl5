package edu.mondragon.dao;

import java.util.List;

import edu.mondragon.model.Ability;

public interface AbilityDao {
	void addAbility(Ability ability);

	List<Ability> listAbilities();

	Ability getAbilityById(int ability_id);
}
