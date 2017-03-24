package com.pg.dp.servicelayer.magic;

import java.util.List;

import com.pg.dp.servicelayer.servicelayer.spell.Spell;
import com.pg.dp.servicelayer.spellbook.Spellbook;
import com.pg.dp.servicelayer.wizard.Wizard;


/**
 * 
 * Service interface.
 *
 */
public interface MagicService {

	List<Wizard> findAllWizards();

	List<Spellbook> findAllSpellbooks();
	
	List<Spell> findAllSpells();

	List<Wizard> findWizardsWithSpellbook(String name);

	List<Wizard> findWizardsWithSpell(String name);
}
