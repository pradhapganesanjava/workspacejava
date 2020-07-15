package solstools.array.path;


/*
 * 
	<a href="https://leetcode.com/problems/reconstruct-itinerary/>332. Reconstruct Itinerary</a>
	
	Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], 
	reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. 
	Thus, the itinerary must begin with JFK.
	
	Note:
	
	If there are multiple valid itineraries, you should 
	return the itinerary that has the smallest lexical order when read as a single string. 
	For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
	All airports are represented by three capital letters (IATA code).
	You may assume all tickets form at least one valid itinerary.
	One must use all the tickets once and only once.
	Example 1:
	
	Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
	Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
	Example 2:
	
	Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
	Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
	Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
	             But it is larger in lexical order.

 * 
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ItineraryReconstruct {

	public static void main(String[] args) {
		ItineraryReconstruct_Solution sol = new ItineraryReconstruct_Solution();
		String[][] sarrs = new String[][] {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
		List<List<String>> tickets = new ArrayList<>();
		for(String[] sarr : sarrs) {
			List<String> lst = new ArrayList<>();
			lst.add(sarr[0]);
			lst.add(sarr[1]);
			tickets.add(lst);
		}

		List<String> rlst = sol.findItinerary(tickets);

	}

}
class ItineraryReconstruct_Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        return chainRecur(tickets);
        // return recur(tickets);
    }
    
    private List<String> chainRecur(List<List<String>> lolst){
        Map<String, PriorityQueue<String>> mp = new HashMap<>();
        for(List<String> lst : lolst){
            mp.computeIfAbsent(lst.get(0), (v) -> new PriorityQueue<String>()).add(lst.get(1));
        }
        List<String> rlst = new LinkedList<>();
        chainRecur(mp, "JFK",rlst);
        return rlst;
    }
    private void chainRecur(Map<String, PriorityQueue<String>> mp, String airprt, List<String> rlst){
        while(mp.containsKey(airprt) && !mp.get(airprt).isEmpty()){
            chainRecur(mp, mp.get(airprt).poll(), rlst);
        }
        rlst.add(0, airprt);
    }
    private List<String> recur(List<List<String>> lolst){
        
        Map<String, List<String>> mplst = new HashMap<>();
        
        for(List<String> lst : lolst){
            String k = lst.get(0);
            String v = lst.get(1);
            mplst.compute(k, (tk, tv) -> {
                if(tv==null){
                    tv = new ArrayList<>();
                }
                tv.add(v);
                return tv;
            });
        }
        List<String> rlst = new ArrayList<>();
        rlst.add("JFK");
        rlst = recur(mplst, "JFK", mplst.size(), rlst);
        return rlst;
    }
    private List<String> recur(Map<String, List<String>> mplst, String frm, int k, List<String> lst){
        if(k==0){
            return lst;
        }
        if(k < 0 || !mplst.containsKey(frm)){
            return null;
        }
        List<String> toLst = mplst.get(frm);
        toLst.sort((s1, s2) -> s1.compareTo(s2));
        for(int i=0; i<toLst.size(); i++){
            List<String> nlst = new ArrayList<>(lst);
            nlst.add(toLst.get(i));
            List<String> rlst = recur(mplst, toLst.get(i), k--, nlst);
            if(null != rlst){
                return rlst;
            }
        }
        return null;
    }
}