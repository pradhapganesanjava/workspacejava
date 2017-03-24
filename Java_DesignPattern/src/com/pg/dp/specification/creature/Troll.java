package com.pg.dp.specification.creature;

import com.pg.dp.specification.property.Color;
import com.pg.dp.specification.property.Movement;
import com.pg.dp.specification.property.Size;

/**
 * 
 * Troll creature.
 *
 */
public class Troll extends AbstractCreature {
	
	public Troll() {
		super("Troll", Size.LARGE, Movement.WALKING, Color.DARK);
	}
}
