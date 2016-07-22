package com.pg.java.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTokenUtil {

	static List<String> getTokens(String pattern, String doc) {
		ArrayList<String> tokens = new ArrayList<String>();
		Pattern tokSplitter = Pattern.compile(pattern);
		Matcher m = tokSplitter.matcher(doc);

		while (m.find()) {
			tokens.add(m.group());
		}

		return tokens;
	}
}
