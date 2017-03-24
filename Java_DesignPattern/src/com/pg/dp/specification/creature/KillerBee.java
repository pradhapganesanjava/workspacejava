package com.pg.dp.specification.creature;

import com.pg.dp.specification.property.Color;
import com.pg.dp.specification.property.Movement;
import com.pg.dp.specification.property.Size;

/**
 * 
 * KillerBee creature.
 *
 */
public class KillerBee extends AbstractCreature {

	public KillerBee() {
		super("KillerBee", Size.SMALL, Movement.FLYING, Color.LIGHT);
	}
}
