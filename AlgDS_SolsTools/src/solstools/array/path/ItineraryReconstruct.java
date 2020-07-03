package solstools.array.path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return recur(tickets);
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