package com.pg.dp.factory.dto;

import com.pg.dp.abstfactory.FactoryHelper;

public interface DoMapper {

	BO INSTANCE = FactoryHelper.getInstance(DO.class);
	
}
