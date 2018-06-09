package com.pg.java.inner;

public class CircleSimpleInnerClass {

	public static void main(String[] args) {

		CircleSimpleInnerClass sic = new CircleSimpleInnerClass();
		int d = 50;
		sic.drawCircle(d, d/2, d/2);
		
	}
	public void drawCircle(int d, int x, int y){
		
		if(x<0 || y>d || x>d/2 || y<0) {
			return;
		}
		Point pt = new Point();
		
		drawPixel(d, x, y, pt);
		
		drawCircle(d, --x, ++y);
		
		drawPixel(d, x, y, pt);
		
		return;
	}
	private void drawPixel(int d, int x, int y, Point pt) {
		for(int i=0; i< d; i++){
			if(i==x || i==y) {
				System.out.print(pt.givePoint());
			};
			System.out.print(" ");
		}
		System.out.println();
	}

	private class Point{
		public String givePoint(){
			return "-";
		}
	}
}
