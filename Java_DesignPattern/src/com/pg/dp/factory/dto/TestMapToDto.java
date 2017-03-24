package com.pg.dp.factory.dto;

public class TestMapToDto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DO doObj = new DO();
		DTO dtoObj = null;
		doObj.setName("Pradhap");
		doObj.setAge(100);
		doObj.setSalary(10000.00);
		
		DOtwo dOtwo = new DOtwo();
		dOtwo.setAge(85);
		dOtwo.setName("VINAYAK");
		dOtwo.setSalary(100.00);
		doObj.setMOtwo(dOtwo);
		
		dtoObj = (DTO) doObj.mapToDto();
		
		System.out.println(dtoObj.toString());

	}

}
