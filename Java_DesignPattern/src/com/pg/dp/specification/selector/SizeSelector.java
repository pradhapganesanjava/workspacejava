package com.pg.dp.specification.selector;

import java.util.function.Predicate;

import com.pg.dp.specification.creature.Creature;
import com.pg.dp.specification.property.Size;

/**
 * 
 * Size selector.
 *
 */
public class SizeSelector implements Predicate<Creature> {

	private final Size s;

	public SizeSelector(Size s) {
		this.s = s;
	}
	
	@Override
	public boolean test(Creature t) {
		return t.getSize().equals(s);
	}
}
