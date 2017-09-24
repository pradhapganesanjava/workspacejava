package com.pg.dp.specification.creature;

import com.pg.dp.specification.property.Color;
import com.pg.dp.specification.property.Movement;
import com.pg.dp.specification.property.Size;

/**
 * 
 * Shark creature.
 *
 */
public class Shark extends AbstractCreature {

	public Shark() {
		super("Shark", Size.NORMAL, Movement.SWIMMING, Color.LIGHT);
	}
}
