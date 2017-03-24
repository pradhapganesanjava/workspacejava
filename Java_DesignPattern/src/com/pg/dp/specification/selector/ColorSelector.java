package com.pg.dp.specification.selector;

import java.util.function.Predicate;

import com.pg.dp.specification.creature.Creature;
import com.pg.dp.specification.property.Color;

/**
 * 
 * Color selector.
 *
 */
public class ColorSelector implements Predicate<Creature> {

	private final Color c;

	public ColorSelector(Color c) {
		this.c = c;
	}
	
	@Override
	public boolean test(Creature t) {
		return t.getColor().equals(c);
	}
}
