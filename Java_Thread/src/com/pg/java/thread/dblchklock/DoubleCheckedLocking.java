package com.pg.java.thread.dblchklock;

public class DoubleCheckedLocking {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final FooSingleThreadFactory fooFactory = new FooSingleThreadFactory();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<500;i++){
					Foo foo = fooFactory.createFoo();
					if(foo==null){
						System.out.println(">"+i+" is NULL?"+(foo==null));
					}else{
						System.out.println(">"+i+" is NULL?"+(foo==null));
					}
				}
			}
		});
		
		t1.start();

	}

}

class FooSingleThreadFactory{
	private Foo fooObj=null;

	// Single-threaded version
	public Foo createFoo(){
		if(fooObj == null){
			fooObj = new Foo();
			return fooObj; }
		return this.fooObj; } }

//Correct but possibly expensive multithreaded version
class FooMultiThreadFactory{
	private Foo fooObj=null;

	// Multi-threaded version
	public synchronized Foo createFoo(){
		if(fooObj == null){
			fooObj = new Foo();
			return fooObj; }
		return this.fooObj; } }

// "Double-Checked Locking" but broken
class FooDblChkLockFactory{
	private Foo fooObj=null;

	// Multi-threaded version
	public Foo createFoo(){
		if(fooObj == null){
			synchronized (this) {
				if(fooObj == null){
					fooObj = new Foo();
					return fooObj; } } }
		return this.fooObj; } }

//"Double-Checked Locking" 25% improved performance: volatile
class FooDblChkLockVolFactory{
	private volatile Foo fooObj;

	// Multi-threaded version
	public Foo createFoo(){
		Foo fooLocalObj = fooObj;
		if(fooLocalObj == null){
			synchronized (this) {
				fooLocalObj=fooObj;
				if(fooLocalObj == null){
					fooLocalObj = fooObj = new Foo();
					return fooLocalObj;					
				}
			}
		}
		return fooLocalObj;
	}
}

class Foo{
	
	private String fName;
	private String lName;
	
	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Foo() {
	}

	
}