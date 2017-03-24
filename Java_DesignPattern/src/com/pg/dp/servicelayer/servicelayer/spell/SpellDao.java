package com.pg.dp.servicelayer.servicelayer.spell;

import com.pg.dp.servicelayer.common.Dao;

/**
 * 
 * SpellDao interface.
 *
 */
public interface SpellDao extends Dao<Spell> {
	
	Spell findByName(String name);

}
