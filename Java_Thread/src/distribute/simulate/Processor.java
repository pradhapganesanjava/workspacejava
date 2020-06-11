package distribute.simulate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Processor {
	private int id = -1;
	RepositoryInput repInput = null;
	public Processor(int id, RepositoryInput repInput) {
		this.id = id;
		this.repInput = repInput;
	}
	public  void process(){
		LinkedList<Map<String,String>> llst = repInput.get(this.id);
		
		for(int i=0; i<llst.size(); i++) {
			Map<String, String> mp = llst.removeFirst();
			Map<String, String> nmp = new HashMap<>(mp);
			try {
				System.out.format("Processor: workerId: %d, readInput: %s \n", id, mp);
				Thread.sleep(1000);
				nmp.put("status","ok");
				System.out.format("Processor: workerId: %d, writeOutput: %s \n", id, nmp);
				RepositoryOutput.output.add(nmp);
			}catch(Exception e) {
				System.out.println(e.getMessage());
				nmp.put("status", "Down");
				RepositoryOutput.output.add(nmp);
			}
		}
	}
}
