package distribute.simulate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		LinkedList<Map<String,String>> wrkLst = new LinkedList<>();
		Map<String,String> mpDef = new HashMap<>();
		mpDef.put(Data.KEY.APP.toString(), "REST");
		mpDef.put(Data.KEY.ENV.toString(), "PROD");
		mpDef.put(Data.KEY.PORT.toString(), "222");
		mpDef.put(Data.KEY.ID.toString(), "0");
		
		for(int i=0; i<100; i++) {
			Map<String, String> nmp = new HashMap(mpDef);
			nmp.put(Data.KEY.ID.toString(), Integer.toString(i));
			wrkLst.add(nmp);
		}
		
		Supervisor supervisor = new Supervisor();
		List<Map<String,String>> rLst = supervisor.work(wrkLst);
		
		rLst.forEach(ech -> System.out.println(ech));
		
	}
	


}
