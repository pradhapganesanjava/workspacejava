package com.pg.dp.flux.store;

import java.util.LinkedList;
import java.util.List;

import com.pg.dp.flux.action.Action;
import com.pg.dp.flux.view.View;

/**
 * 
 * Store is a data model.
 *
 */
public abstract class Store {
	
	private List<View> views = new LinkedList<>();
	
	public abstract void onAction(Action action);

	public void registerView(View view) {
		views.add(view);
	}
	
	protected void notifyChange() {
		views.stream().forEach((view) -> view.storeChanged(this));
	}
}
