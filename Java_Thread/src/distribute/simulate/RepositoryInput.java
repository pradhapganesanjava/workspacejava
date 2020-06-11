package distribute.simulate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RepositoryInput {
	int CAPS = 0;
	public RepositoryInput() {
	}
	public RepositoryInput(int mxsize) {
		CAPS = mxsize;
	}
	private List<LinkedList<Map<String, String>>> input = new ArrayList<>(CAPS);
	
	public void add(int idx, Map<String, String> mp) {
		if(input.size()-1 < idx) {
			for(int i=input.size(); i<=idx; i++) {
				input.add(new LinkedList<Map<String, String>>());
			}
		}
		input.get(idx).add(mp);
	}
	
	public LinkedList<Map<String, String>> get(int idx) {
		if(input.size()-1 < idx) {
			return new LinkedList<Map<String, String>>();
		}
		return input.get(idx);
	}
	/*
	public Map<String, String> removeFirst(int idx) {
		if(input.size()-1 < idx) {
			return null;
		}
		return input.get(idx).removeFirst();
	}*/
	
	public int size(int idx) {
		if(input.size()-1 < idx) {
			return 0;
		}
		return input.get(idx).size();
	}
}
