package com.pg.alg.compare.listoflist;

import java.util.ArrayList;
import java.util.List;

public class FindPairsGreater0 {

	public static void main(String[] args) {
		List<Doc> docLst = new ArrayList<>();
		
		docLst.add(new Doc(10, new int[] {11, 13, 15, 16, 18, 10}));
		docLst.add(new Doc(13, new int[] {31, 13, 11, 33, 1, 3}));
		docLst.add(new Doc(16, new int[] {61, 11, 66, 60, 1, 6, 10}));
		docLst.add(new Doc(1, new int[] {111}));
		docLst.add(new Doc(3, new int[] {33, 3, 30}));
		docLst.add(new Doc(6, new int[] {6, 60}));
		
		for(Doc doc1 : docLst) {
			for(Doc doc2 : docLst) {
				if(doc1 == doc2) continue;
				
                List<Integer> unionLst = new ArrayList<>();
                	int intersCnt = 	uniInterCnt(doc1, doc2, unionLst);
				int unionCnt = unionLst.size();
				// int intersCnt = intersectionCnt(unionLst, doc1.wordsCnt);
                if(intersCnt > 0){
                    double sparse = (double) ( (0.0 + intersCnt) / unionCnt);
                    System.out.format("docId: %d, docId: %d , sparse: %f \n", doc1.docId, doc2.docId, sparse);
                }else {
                		System.err.format("docId: %d, docId: %d , sparse: %f \n", doc1.docId, doc2.docId, 0.0);
                }
			}
		}
	}

	private static int uniInterCnt(Doc doc1, Doc doc2, List<Integer> unionLst) {
        List<Integer> lst1 = doc1.wordsCnt;
        List<Integer> lst2 = doc2.wordsCnt;

		lst1.sort(FindPairsGreater0::compareWordLst);
        lst2.sort(FindPairsGreater0::compareWordLst);
		
        int idx1 = 0;
        int idx2 = 0;
        int ix1 = lst1.size();
        int ix2 = lst2.size();
        int intersCnt = 0;

        while(idx1 < ix1 && idx2 < ix2 ){
            if(lst1.get(idx1) < lst2.get(idx2)){
                unionLst.add(lst1.get(idx1)); 
                idx1++;
            }else if(lst1.get(idx1) == lst2.get(idx2)){
                unionLst.add(lst1.get(idx1)); 
                idx1++;
                idx2++;
                intersCnt++;
            }else{
                unionLst.add(lst2.get(idx2)); 
                idx2++;
            }
        }

        while(idx1<ix1){
            unionLst.add(lst1.get(idx1)); 
            idx1++;
        }

        while(idx2<ix2){
            unionLst.add(lst2.get(idx2)); 
            idx2++;
        }

		return intersCnt;
	}

	private static int intersectionCnt(List<Integer> unionLst, List<Integer> docLst) {
        int interCnt = 0;
        for(int uniInt : unionLst ){
            for(int docInt : docLst ){
                if( uniInt == docInt ){
                    interCnt++;
                }
            }
        }

		return interCnt;
	}
	
	private static int compareWordLst(Integer i1, Integer i2) {
		return i1.compareTo(i2);
	}

}

class Doc{
	List<Integer> wordsCnt = new ArrayList<>();
	Integer docId = null;
	
	public Doc(int docId, int[] iarr) {
		for(int i : iarr) {
			this.wordsCnt.add(i);
		}
		this.docId = docId;
	}
	@Override
	public int hashCode() {
		return this.docId;
	}
	
	@Override
	public boolean equals(Object obj2) {
		if(obj2 == null) return false;
		if(! (obj2 instanceof Doc)) return false;
		
		return this.docId == ((Doc)obj2).docId;
	}
	
}
