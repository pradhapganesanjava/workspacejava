package com.pg.java.thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierHello {

	public static void main(String... str) {
		CountryPopulationService service = new CountryPopulationService();
		System.out.println("Total population "+ service.calcPopulation());
	}
}

class CountryPopulationService {

	private long population = 0;

	private long nPop = 0;
	private long sPop = 0;
	private long ePop = 0;
	private long wPop = 0;

	public CountryPopulationService() {
	}

	public long calcPopulation() {
		CyclicBarrier cycBar = new CyclicBarrier(4);

		ExecutorService executor = Executors.newFixedThreadPool(4);
		executor.submit(new NorthThread(cycBar, this));
		executor.submit(new SouthThread(cycBar, this));
		executor.submit(new EastThread(cycBar, this));
		executor.submit(new WestThread(cycBar, this));

		executor.shutdown();

		try {
			executor.awaitTermination(3, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.setPopulation(this.getnPop() + this.getsPop() + this.getePop() + this.getwPop());
		return this.getPopulation();
	}

	public long northPopulation() {
		this.setnPop(900);
		return this.getnPop();
	}

	public long southPopulation() {
		this.setsPop(500);
		return this.getsPop();
	}

	public long eastPopulation() {
		this.setePop(300);
		return this.getePop();
	}

	public long westPopulation() {
		this.setwPop(400);
		return this.getwPop();
	}

	public long getPopulation() {
		return population;
	}

	public long getnPop() {
		return nPop;
	}

	public long getsPop() {
		return sPop;
	}

	public long getePop() {
		return ePop;
	}

	public long getwPop() {
		return wPop;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public void setnPop(long nPop) {
		this.nPop = nPop;
	}

	public void setsPop(long sPop) {
		this.sPop = sPop;
	}

	public void setePop(long ePop) {
		this.ePop = ePop;
	}

	public void setwPop(long wPop) {
		this.wPop = wPop;
	}

}

class NorthThread implements Runnable {

	private CyclicBarrier cycBar = null;
	private CountryPopulationService countryPopulationSrv;

	public NorthThread(CyclicBarrier cycBar, CountryPopulationService countryPopulationSrv) {
		this.cycBar = cycBar;
		this.countryPopulationSrv = countryPopulationSrv;
	}

	@Override
	public void run() {
		countryPopulationSrv.northPopulation();
		System.out.println("North population calculation PROCESSED");
		try {
			System.out.println("North population WAIT...");
			cycBar.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("North population EXIT");
	}
}

class SouthThread implements Runnable {

	private CyclicBarrier cycBar = null;
	private CountryPopulationService countryPopulationSrv;

	public SouthThread(CyclicBarrier cycBar, CountryPopulationService countryPopulationSrv) {
		this.cycBar = cycBar;
		this.countryPopulationSrv = countryPopulationSrv;
	}

	@Override
	public void run() {
		countryPopulationSrv.southPopulation();
		System.out.println("SOUTH population calculation PROCESSED");
		try {
			System.out.println("SOUTH population WAIT...");
			cycBar.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("SOUTH population EXIT");
	}
}

class EastThread implements Runnable {

	private CyclicBarrier cycBar = null;
	private CountryPopulationService countryPopulationSrv;

	public EastThread(CyclicBarrier cycBar, CountryPopulationService countryPopulationSrv) {
		this.cycBar = cycBar;
		this.countryPopulationSrv = countryPopulationSrv;
	}

	@Override
	public void run() {
		countryPopulationSrv.eastPopulation();
		System.out.println("EAST population calculation PROCESSED");
		try {
			System.out.println("EAST population WAIT...");
			cycBar.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("EAST population EXIT");
	}
}

class WestThread implements Runnable {

	private CyclicBarrier cycBar = null;
	private CountryPopulationService countryPopulationSrv;

	public WestThread(CyclicBarrier cycBar, CountryPopulationService countryPopulationSrv) {
		this.cycBar = cycBar;
		this.countryPopulationSrv = countryPopulationSrv;
	}

	@Override
	public void run() {
		countryPopulationSrv.westPopulation();
		System.out.println("WEST population calculation PROCESSED");
		try {
			System.out.println("WEST population WAIT...");
			cycBar.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("WEST population EXIT");
	}
}