var deck_1;
var deck_2;

function startBattle(deck_1, deck_2) {
	this.deck_1 = deck_1;
	this.deck_2 = deck_2;
	var hero_1;
	var hero_2;
	var player_1_points = 0;
	var player_2_points = 0;
	
	for (var i = 0; i < 5; i++) {
		hero_1 = deck_1[i];
		hero_2 = deck_2[i];
		
		if (startRound(hero_1, hero_2)) {
			player_1_points++;
		} else {
			player_2_points++;
		}
	}
	console.log(player_1_points);
	console.log(player_2_points);
}

function startRound(hero_1, hero_2) {
	var is_hero_1_winner;

	do {
		startTurn();
	} while (hero_1.getHp() > 0 && hero_2.getHp() > 0);

	if (hero_1.getHp() > 0) {
		is_card_1_winner = true;
	} else {
		is_card_1_winner = false;
	}
	return is_card_1_winner;
}

function startTurn() {
	var speedComparison = hero_1.spd / hero_2.spd;
	
	if (Math.random() < ((speedComparison >= 1) ? (0.5 * speedComparison) : (0.5 / speedComparison))) {
		hero_1_moves();
		if (hero_2.getHp() > 0) {
			hero_2_moves();
		}
	} else {
		hero_2_moves();
		if (hero_1.getHp() > 0) {
			hero_1_moves();
		}
	}
}

function hero_1_moves() {
	var physicalOrMagical;
	var dodgeOrBlock;
	var fail;
	
	var physicalRelation = hero_1.getAttack() / hero_2.getDefense();
	var magicalRelation = hero_1.getMagicalAttack() / hero_2.getMagicalDefense();
	var physicalMagicalRelation = physicalRelation / magicalRelation;
	var hero_2_tankiness;
	
	var type = 1;
	var ability = 1;

	if (Math.random() < ((physicalMagicalRelation >= 1) ? (0.5 * physicalMagicalRelation) : (0.5 / physicalMagicalRelation))) {
		physicalOrMagical = true;
	} else {
		physicalOrMagical = false;
	}
	
	hero_2_tankiness = ((hero_2.getHp() + ((physicalOrMagical) ? hero_2.getDefense() : hero_2.getMagicalDefense())) / 2);

	if (hero_2.getSpeed() > hero_2_tankiness) {
		dodgeOrBlock = true;
	} else if (hero_2.getSpeed() < hero_2_tankiness) {
		dodgeOrBlock = false;
	} else {
		dodgeOrBlock = (Math.random() < 0.5) ? true : false;
	}

	if (Math.random() < (0.125 / ((dodgeOrBlock == true) ? speedRelation : ((physicalOrMagical) ? physicalRelation : magicalRelation)))) {
		fail = true;
	} else {
		fail = false;
	}

	if (fail == false) {
		var dmg = 25 * ((physicalOrMagical) ? physicalRelation : magicalRelation) * type * ability;
		hero_2.setHp(hero_2.getHp() - dmg);
	}
}

function hero_2_moves() {
	var physicalOrMagical;
	var dodgeOrBlock;
	var fail;
	
	var physicalRelation = hero_2.getAttack() / hero_1.getDefense();
	var magicalRelation = hero_2.getMagicalAttack() / hero_1.getMagicalDefense();
	var physicalMagicalRelation = physicalRelation / magicalRelation;
	var hero_1_tankiness;

	var type = 1;
	var ability = 1;

	if (Math.random() < ((physicalMagicalRelation >= 1) ? (0.5 * physicalMagicalRelation) : (0.5 / physicalMagicalRelation))) {
		physicalOrMagical = true;
	} else {
		physicalOrMagical = false;
	}
	
	hero_1_tankiness = ((hero_1.getHp() + ((physicalOrMagical) ? hero_1.getDefense() : hero_1.getMagicalDefense())) / 2);

	if (hero_1.getSpeed() > hero_1_tankiness) {
		dodgeOrBlock = true;
	} else if (hero_1.getSpeed() < hero_1_tankiness) {
		dodgeOrBlock = false;
	} else {
		dodgeOrBlock = (Math.random() < 0.5) ? true : false;
	}

	if (Math.random() < (0.125 / ((dodgeOrBlock == true) ? speedRelation : ((physicalOrMagical) ? physicalRelation : magicalRelation)))) {
		fail = true;
	} else {
		fail = false;
	}

	if (fail == false) {
		var dmg = 25 * ((physicalOrMagical) ? physicalRelation : magicalRelation) * type * ability;
		hero_1.setHp(hero_1.getHp() - dmg);
	}
}