package com.pg.java.algorithm.luhn;

public class GenGSMESNs {

	//Just for reference - RBI NUMS are GSM
	private static final String[] RBI_NUMS = { "00", "01", "02", "03", "04",
			"05", "06", "07", "08", "09", "10", "30", "33", "35", "44", "45",
			"49", "50", "51", "52", "53", "54", "86", "91", "98", "99" };

	//Just for reference - GSM esn length
	private static final int[] GSM_ESN_LENGTH = { 15, 16 };

	
	
	//Modify local parameters to get desired result
	private static final int numOf_GSM_ESN = 30;
	private static final String GSM_ESN_StartWith = "49";
	
	
	public static void main(String[] args) {

		int index = 0;
		int increment = 0;
		
		while (index < numOf_GSM_ESN) {

			String gsmESNTemp = getGSMESNWithLength(GSM_ESN_StartWith + increment, 16);

			if (checkLuhn(gsmESNTemp)) {
				index++;
				System.out.println(gsmESNTemp);
			}
			increment++;
		}

	}

	public static String getGSMESNWithLength(String gsmStartWith, int length) {
		if (null == gsmStartWith || "".equals(gsmStartWith)) {
			gsmStartWith = "00";
		}
		
		StringBuffer strBuff = new StringBuffer(gsmStartWith);

		while (strBuff.length() < length) {
			strBuff.append("0");
		}

		return strBuff.toString();
	}

	public static boolean checkLuhn(String number) {
		int sum = 0;
		boolean alternate = false;
		for (int i = number.length() - 1; i >= 0; i--) {
			int n = Integer.parseInt(number.substring(i, i + 1));
			if (alternate) {
				n *= 2;
				if (n > 9) {
					n = (n % 10) + 1;
				}
			}
			sum += n;
			alternate = !alternate;
		}
		return (sum % 10 == 0);
	}

}
