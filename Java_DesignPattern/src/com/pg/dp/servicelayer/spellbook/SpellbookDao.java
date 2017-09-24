package com.pg.dp.servicelayer.spellbook;

import com.pg.dp.servicelayer.common.Dao;

/**
 * 
 * SpellbookDao interface.
 *
 */
public interface SpellbookDao extends Dao<Spellbook> {
	
	Spellbook findByName(String name);

}
