package com.pg.dp.specification.selector;

import java.util.function.Predicate;

import com.pg.dp.specification.creature.Creature;
import com.pg.dp.specification.property.Movement;

/**
 * 
 * Movement selector.
 *
 */
public class MovementSelector implements Predicate<Creature> {
	
	private final Movement m;

	public MovementSelector(Movement m) {
		this.m = m;
	}

	@Override
	public boolean test(Creature t) {
		return t.getMovement().equals(m);
	}
}
