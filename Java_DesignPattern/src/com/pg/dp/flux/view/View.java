package com.pg.dp.flux.view;

import com.pg.dp.flux.store.Store;

/**
 * 
 * Views define the representation of data.
 *
 */
public interface View {

	public void storeChanged(Store store);

	public void render();
}
