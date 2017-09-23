package Collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Collections.synchronizedList is required for this case. Means, collection is shared by multiple threads. simple 
 * 
 */
public class CollectionsSynchronizationTest {
	
	static List<Integer> toProcess = Collections.synchronizedList(new LinkedList<Integer>());
	
	public static void main(String...str){
		final Loader loader = new Loader();
		Thread loaderT = new Thread( new Runnable() {
			@Override
			public void run() {
				while(true){
					int size = toProcess.size();
					int count = size+1;
					if(size<100){
						System.out.println(count+" : load? "+loader.load(toProcess,count));
					}
				}
			}
		}); 
		final UnLoader unLoader = new UnLoader();
		Thread unLoaderT = new Thread( new Runnable() {
			@Override
			public void run() {
				while(true){
					System.out.println("-----------------unloader size "+toProcess.size());
					if(toProcess.size()>0){
						System.out.println("-----------------pop? "+unLoader.unLoad(toProcess));
					}
				}
			}
		}); 
		
		loaderT.start();
		unLoaderT.start();
	}
	
}

class Loader{
	public boolean load(List<Integer> queInt, Integer intV){
		queInt.add(intV);
		return true;
	}
}

class UnLoader{
	public Integer unLoad(List<Integer> queInt){
		if(null != queInt){
			return queInt.remove(0);
		}
		return -1;
	}
}