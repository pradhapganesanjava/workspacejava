package solstools.array.subsequence;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AllSubsequence {
	private static AllSubsequence_Solution sol;
	public static void main(String[] args) {
		String s = "abcd";
		List<String> slst = sol.generateAllSubseq(s);
		slst.forEach(ech -> System.out.println(ech));
	}

}
class AllSubsequence_Solution{
	public static List<String> generateAllSubseq(String s){
		return genAllSubseq(s);
	}
	
	private static List<String> genAllSubseq(String s){
		return genAllSubseq_Strb(s);
		//return genAllSubseq_ChList(s);
		//return genAllSubseq_BFS(s);
	}

	private static List<String> genAllSubseq_BFS(String s) {
		List<String> q = new LinkedList<>();
		q.add("");
		for (int i = 0; i < s.length(); i++) {
			int sz = q.size();
			for (int j = 0; j < sz; j++) {
				//String ns = sb.substring(0,k)+String.valueOf(s.charAt(i))+sb.substring(k);
				String ns = q.get(j) +String.valueOf(s.charAt(i));
				q.add(ns);
			}
		}
		return q;
	}

	private static List<String> genAllSubseq_ChList(String s) {
		List<Character> chlst = new ArrayList<>();
		List<String> slst = new ArrayList<>();
		genAllSubseq_ChList(s, 0, chlst, slst);
		return slst;
	}

	private static void genAllSubseq_ChList(String s, int idx, List<Character> chlst, List<String> slst) {
		slst.add(chlst.stream().map(String::valueOf).collect(Collectors.joining()));
		for(int i=idx; i<s.length(); i++) {
			List<Character> nchlst = new ArrayList<>(chlst);
			nchlst.add(s.charAt(i));
			genAllSubseq_ChList(s, i+1, nchlst, slst);
		}
	}

	private static List<String> genAllSubseq_Strb(String s) {
		List<String> slst = new ArrayList<>();
		StringBuilder strb = new StringBuilder();
		genAllSubseq_Strb(s, 0, strb, slst);
		return slst;
	}

	private static void genAllSubseq_Strb(String s, int idx, StringBuilder strb, List<String> slst) {
		
		for(int i=idx; i<s.length(); i++) {
			strb.append(s.charAt(i));
			slst.add(strb.toString());
			genAllSubseq_Strb(s, i+1, strb, slst);
			strb.setLength(strb.length()-1);
		}
	}
}