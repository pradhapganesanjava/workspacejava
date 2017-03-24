package com.pg.dp.flux.store;

import com.pg.dp.flux.action.Action;
import com.pg.dp.flux.action.ActionType;
import com.pg.dp.flux.action.MenuAction;
import com.pg.dp.flux.action.MenuItem;

/**
 * 
 * MenuStore is a concrete store.
 *
 */
public class MenuStore extends Store {

	private MenuItem selected = MenuItem.HOME;
	
	@Override
	public void onAction(Action action) {
		if (action.getType().equals(ActionType.MENU_ITEM_SELECTED)) {
			MenuAction menuAction = (MenuAction) action;
			selected = menuAction.getMenuItem();
			notifyChange();
		}
	}
	
	public MenuItem getSelected() {
		return selected;
	}
}
