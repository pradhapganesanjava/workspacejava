package com.pg.dp.specification.creature;

import com.pg.dp.specification.property.Color;
import com.pg.dp.specification.property.Movement;
import com.pg.dp.specification.property.Size;

/**
 * 
 * Goblin creature.
 *
 */
public class Goblin extends AbstractCreature {

	public Goblin() {
		super("Goblin", Size.SMALL, Movement.WALKING, Color.GREEN);
	}
}
