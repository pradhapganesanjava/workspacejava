package com.pg.dp.specification.creature;

import com.pg.dp.specification.property.Color;
import com.pg.dp.specification.property.Movement;
import com.pg.dp.specification.property.Size;

/**
 * 
 * Octopus creature.
 *
 */
public class Octopus extends AbstractCreature {

	public Octopus() {
		super("Octopus", Size.NORMAL, Movement.SWIMMING, Color.DARK);
	}
}
