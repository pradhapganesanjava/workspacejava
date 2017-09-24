package com.pg.dp.servicelayer.wizard;

import com.pg.dp.servicelayer.common.Dao;

/**
 * 
 * WizardDao interface.
 *
 */
public interface WizardDao extends Dao<Wizard> {
	
	Wizard findByName(String name);

}
