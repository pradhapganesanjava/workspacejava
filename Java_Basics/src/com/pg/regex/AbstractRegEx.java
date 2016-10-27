package com.pg.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractRegEx {
	
	private String text;
	public AbstractRegEx() {
	}

	public AbstractRegEx(String text) {
		this.text = text;
	}
	
	public List<String> applyRegEx(String pattern){
		List<String> applyRegEx = new ArrayList<String>(0);
		Pattern patternCompiled = Pattern.compile(pattern);
		Matcher matcher = patternCompiled.matcher(text);
		while(matcher.find()){
			applyRegEx.add(matcher.group());
		}
		return applyRegEx;
	}
	
	public List<String> applyRegEx(String textLocal, String pattern){
		List<String> applyRegEx = new ArrayList<String>(0);
		Pattern patternCompiled = Pattern.compile(pattern);
		Matcher matcher = patternCompiled.matcher(textLocal);
		while(matcher.find()){
			applyRegEx.add(matcher.group());
		}
		return applyRegEx;
	}
}
