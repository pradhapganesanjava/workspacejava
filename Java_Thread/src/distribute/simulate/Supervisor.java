package distribute.simulate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Supervisor {
	public List<Map<String, String>> work(LinkedList<Map<String, String>> workLst){
		int N = 20;
		final int MX_LOAD = workLst.size()/2*N;
		final int MX_RETRY = 10;
		
		RepositoryInput repInput = new RepositoryInput(N);
		
		Map<Integer, Processor> workers = new HashMap<>();
		for(int i=0; i<N; i++) {
			workers.put(i, new Processor(i, repInput));
		}

		
		System.out.println();
		
		ExecutorService executorSrv = Executors.newFixedThreadPool(N, new ThreadFactory() {
	        @Override
	        public Thread newThread(Runnable r) {
	            Thread t = new Thread(r);
	            t.setDaemon(true);
	            return t;
	        }});
		
		int iworker = 0;
		int cntIter = 0;
		try {
			while(!workLst.isEmpty()) {
	
				System.out.format("Supervisor: iworker: %d Load: %d CHECK \n", iworker, repInput.size(iworker));
				while(!workLst.isEmpty() && repInput.size(iworker) < MX_LOAD) {
					Map<String,String> work = workLst.removeFirst();
					System.out.format("Supervisor: iworker: %d Load: %d Submitting work: %s \n", iworker, repInput.size(iworker), work);
					repInput.add(iworker, work);
					executorSrv.execute(workers.get(iworker)::process);
					iworker++;
					if(iworker == N) {
						iworker = 0;
					}
					cntIter = 0;
				}
	
				if(workLst.size()>0) {
					System.err.println("iWorkder: "+iworker +" is 100% Busy...");
					if(cntIter>1) {
						try {
							System.err.println("Supervisor takes break...");
							Thread.sleep(100);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				

				
				iworker++;
				if(iworker == N) {
					iworker = 0;
				}
				cntIter++;
				
				if(cntIter == MX_RETRY) {
					System.err.format("...ALL WORKERS ARE BUSY ... MX_RETRY %d is reached.. CHECK",MX_RETRY);
					break;
				}
			}
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}

		List<Map<String, String>> outLst =  RepositoryOutput.output;
		outLst.forEach(ech -> System.out.println(ech));
		executorSrv.shutdown();
		return outLst;
	}
}
