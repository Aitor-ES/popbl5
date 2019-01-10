package edu.mondragon.ability;

import java.util.List;

public interface AbilityDao {
	void addAbility(Ability ability);

	List<Ability> listAbilities();

	Ability getAbilityById(int ability_id);
}
