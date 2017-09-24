package com.pg.dp.flux.view;

import com.pg.dp.flux.action.Content;
import com.pg.dp.flux.store.ContentStore;
import com.pg.dp.flux.store.Store;

/**
 * 
 * ContentView is a concrete view.
 *
 */
public class ContentView implements View {

	private Content content = Content.PRODUCTS;

	@Override
	public void storeChanged(Store store) {
		ContentStore contentStore = (ContentStore) store;
		content = contentStore.getContent();
		render();
	}

	@Override
	public void render() {
		System.out.println(content.toString());
	}
}
