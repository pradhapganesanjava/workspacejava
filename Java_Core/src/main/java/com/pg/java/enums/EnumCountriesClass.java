package com.pg.java.enums;

import java.util.TimeZone;

public class EnumCountriesClass {

	enum COUNTRY{
		USA, IND, AUS,NZ,CHI,JAP
	}
	
	
	enum TIMEZONE{
		EST("US/Eastern"), CST("US/Central"), PST("US/Pacific"),IST("Asia/Calcutta");
		public TimeZone timeZone;
		private TIMEZONE(String timeZoneValue) {
			this.timeZone = TimeZone.getTimeZone(timeZoneValue);
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//countryEnumTest(args);
		timezoneEnumTest("EST");
	}
	private static void countryEnumTest(String[] args) {
		switch(COUNTRY.valueOf(args[0])){
		case USA:
			System.out.println("Country is USA");break;
		case IND:
			System.out.println("Country is India");break;
		case AUS:
			System.out.println("Country is Australia");break;
		case NZ:
			System.out.println("Country is NewZealand");break;
		default:
			System.out.println("Invalid Country");
			
			
		}
	}

	private static void timezoneEnumTest(String args) {
		switch(TIMEZONE.valueOf(args)){
		case EST:
			System.out.println("TIMEZONE is EST "+TIMEZONE.EST.timeZone);break;
		case CST:
			System.out.println("TIMEZONE is CST "+TIMEZONE.CST.timeZone);break;
		case PST:
			System.out.println("TIMEZONE is PST "+TIMEZONE.PST.timeZone);break;
		case IST:
			System.out.println("TIMEZONE is IST "+TIMEZONE.IST.timeZone);break;
		default:
			System.out.println("Invalid Country");
			
			
		}
	}
}
