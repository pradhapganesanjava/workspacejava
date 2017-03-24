package com.pg.dp.flux.store;

import com.pg.dp.flux.action.Action;
import com.pg.dp.flux.action.ActionType;
import com.pg.dp.flux.action.Content;
import com.pg.dp.flux.action.ContentAction;

/**
 * 
 * ContentStore is a concrete store.
 *
 */
public class ContentStore extends Store {

	private Content content = Content.PRODUCTS;

	@Override
	public void onAction(Action action) {
		if (action.getType().equals(ActionType.CONTENT_CHANGED)) {
			ContentAction contentAction = (ContentAction) action;
			content = contentAction.getContent();
			notifyChange();
		}
	}
	
	public Content getContent() {
		return content;
	}
}
