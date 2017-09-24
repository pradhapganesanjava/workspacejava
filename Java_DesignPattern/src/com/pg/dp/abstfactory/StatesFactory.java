package com.pg.dp.abstfactory;


public interface StatesFactory{
	public <T>T createStatesFactory(Class<? extends States> stateClass);
}
