package com.pg.dp.specification.creature;

import com.pg.dp.specification.property.Color;
import com.pg.dp.specification.property.Movement;
import com.pg.dp.specification.property.Size;

/**
 * 
 * Dragon creature.
 *
 */
public class Dragon extends AbstractCreature {

	public Dragon() {
		super("Dragon", Size.LARGE, Movement.FLYING, Color.RED);
	}
}
