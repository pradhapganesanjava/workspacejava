package com.pg.dp.abstfactory;


public class IndiaStateFactory implements CountryFactory, StatesFactory{

	@Override
	public Country createCountry() {
		try {
			return FactoryHelper.getInstance(India.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * if(StringUtils.isNotBlank(classname) &&
		 * classname.toUpperCase().contains("FLORIDA")){ return
		 * FactoryHelper.getInstance(Florida.class.getName()); }else
		 * if(StringUtils.isNotBlank(classname) &&
		 * classname.toUpperCase().contains("TEXAS")){ return
		 * FactoryHelper.getInstance(Texas.class.getName()); }else{ return new
		 * USAStateFactory(); }
		 */
		return null;
	}
	
	@Override
	public <T>T createStatesFactory(Class<? extends States> stateClass) {
		try {
			return (T)FactoryHelper.getInstance(stateClass);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	/*public static Object getInstance(String classname) {
		if(StringUtils.isNotBlank(classname) && classname.toUpperCase().contains("TAMILNADU")){
			return FactoryHelper.getInstance(TamilNadu.class.getName());
		}else if(StringUtils.isNotBlank(classname) && classname.toUpperCase().contains("KARNATAKA")){
			return FactoryHelper.getInstance(Karnataka.class.getName());
		}else{
			return new IndiaStateFactory();
		}
	}*/

}