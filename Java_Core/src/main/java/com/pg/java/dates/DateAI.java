package com.pg.java.dates;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.sun.media.sound.InvalidFormatException;

public class DateAI {

	private String strDate = null;
	private String[] DATE_DELIM = {"-","/"," "};
	
	final String YEAR = "YEAR";
	final String MON = "MONTH";
	final String DATE = "DATE";
	
	String[] yyyyMMdd = new String[] { YEAR, MON, DATE };
	String[] MMMddyyyy = new String[] { MON, DATE, YEAR };
	Map<String, String> dtFormatsChain = new HashMap<String, String>();
	
	/*private Map<String, String> buildPossibleFormats(String...strArr){
		if(null == strArr || strArr.length != 3) return dtFormatsChain;
		//dtFormatsChain.put(, value)
	}*/
	public static void main(String...str){
		DateAI dt = new DateAI("18-10-2011");
		DateParserAbst dateParsersCurr = null;
		DateParserAbst dateParsersHead = null;
		for(String delimit : dt.DATE_DELIM){
			if(null == dateParsersCurr) { dateParsersCurr = dt.new DateParser(delimit); dateParsersHead = dateParsersCurr; continue; }
			DateParserAbst dateParsersNew = dt.new DateParser(delimit);
			dateParsersCurr.next(dateParsersNew);
			dateParsersCurr = dateParsersNew;
		}
		System.out.println("dateParsers "+dateParsersHead);
	}
	
	public DateAI(String strDate) {
		this.strDate = strDate;
	}
	
	private abstract class DateParserAbst{
		DateParserAbst next;
		String delimit;
		public DateParserAbst(String delimit) {
			this.delimit = delimit;
		}
		public DateParserAbst next(DateParserAbst next){
			this.next = next;
			return next;
		}
		public Date nextParser(String strDate){
			if(null != next){
				return next.nextParser(strDate);
			}
			return null;
		}
		public Date parse(String strDate){
			String[] delimited = strDate.trim().split(this.delimit);
			if (delimited.length == 3) {
				try {
					monthFormat(delimited);
					yearFormat(delimited);
				} catch (InvalidFormatException e) {
					e.printStackTrace();
				}
			}	
			return null;
		}
		private String yearFormat(String[] delimited) throws InvalidFormatException {
			if(delimited[2].length()==2) {
				return "yy";
			}else if(delimited[2].length()==4) {
				return "yyyy";
			}
			if(delimited[2].length()==1) throw new InvalidFormatException("Invalid");
			return "yy";
		}
		private String monthFormat(String[] delimited) throws InvalidFormatException {
			if(delimited[1].length()==1|delimited[1].length()==2) {
				return "MM";
			}else if(delimited[1].length()==3) {
				return "MMM";
			}
			return "MM";
		}
		
		public boolean isParseable(String strDate){
			return isDelimited(strDate) && isValidFormat(this.delimit);
		}
		private boolean isDelimited(String strDate) {
			return strDate.indexOf(this.delimit) > 0;
		}
		
		private boolean isValidFormat(String strDate){
			if(null == strDate || "" == strDate || strDate.length() < 4) return false;
			String[] delimited = strDate.trim().split(this.delimit);
			return delimited.length == 3;
		}
	}
	
	private class DateParser extends DateParserAbst{
		public DateParser(String delimit) {
			super(delimit);
		}
		public Date nextParser(String strDate){
			if(isParseable(strDate)){
				return this.parse(strDate);
			}else{
				return super.nextParser(strDate);
			}
		}
	}
}
