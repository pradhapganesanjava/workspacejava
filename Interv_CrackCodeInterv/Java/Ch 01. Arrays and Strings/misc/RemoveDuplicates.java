package misc;

import java.util.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {
		System.out.println("aaaa removedDup:" +  removeDuplicatesEff("aaaa".toCharArray()));
		System.out.println("aabb removedDup:" +  removeDuplicatesEff("aabb".toCharArray()));
	}

	public static String removeDuplicatesEff(char[] str) {
		if (str == null)
			return null;
		int len = str.length;
		if (len < 2)
			return null;
		boolean[] hit = new boolean[256];
//		for (int i = 0; i < 256; ++i) {
//			hit[i] = false;
//		}
		hit[str[0]] = true;
		int tail = 1;
		for (int i = 1; i < len; i++) {
			if (!hit[str[i]]) {
				str[tail] = str[i];
				tail++;
				hit[str[i]] = true;
			}else{
				str[i] = 0;
			}
		}
		
		return String.valueOf(str);
	}
}
