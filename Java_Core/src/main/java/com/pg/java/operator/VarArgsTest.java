package com.pg.java.operator;

public class VarArgsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(" 0 "+isMatchInVarargs("TC"));
		System.out.println(" 1 empty "+isMatchInVarargs("TC",""));
		System.out.println(" 1 null "+isMatchInVarargs("TC",null));
		
		System.out.println(" 1  "+isMatchInVarargs("TC","NT"));
		System.out.println(" 2  "+isMatchInVarargs("TC","NT","tc"));
		System.out.println(" 2 null "+isMatchInVarargs("TC","NT",null));
		System.out.println(" 3 null "+isMatchInVarargs("TC","TC",null,"NT"));
		System.out.println(" 3 "+isMatchInVarargs("TC","ST","NT","TCC"));
		System.out.println(" tc ,TC ,Tc ,tC "+isMatchInVarargs("TC","tc","TC","Tc","tC"));
		

	}

	public static boolean isMatchInVarargs(String compareName,
			String... namesToCompare) {

		boolean isMatchInBrands = false;

		if (null == compareName || "".equals(compareName.trim())) {
			return false;
		}
		if (null == namesToCompare || namesToCompare.length == 0) {
			return false;
		}

		try {
			int count = namesToCompare.length;
			int index = 0;

			while (count > 0) {

				String namesToCompareStr = namesToCompare[index];
				
				if (compareName.equalsIgnoreCase(namesToCompareStr)) {
					isMatchInBrands = true;
				} else {
					return false;
				}

				index++;
				count--;
			}
		} catch (Exception exception) {

		}

		return isMatchInBrands;
	}

}
