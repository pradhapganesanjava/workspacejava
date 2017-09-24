package com.pg.dp.specification.creature;

import com.pg.dp.specification.property.Color;
import com.pg.dp.specification.property.Movement;
import com.pg.dp.specification.property.Size;

/**
 * 
 * Creature interface.
 *
 */
public interface Creature {

	String getName();
	
	Size getSize();
	
	Movement getMovement();
	
	Color getColor();
}
