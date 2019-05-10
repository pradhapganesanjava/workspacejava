package com.pg.alg.util;

import java.util.ArrayList;
import java.util.List;

public class SortObj {

	public static void main(String[] args) {
		SortObj _this = new SortObj();
		List<Coord> objLst = new ArrayList<>();
		
		objLst.add(_this.new Coord(4, 1));
		objLst.add(_this.new Coord(4, 5));
		objLst.add(_this.new Coord(6, 3));
		objLst.add(_this.new Coord(2, 11));
		objLst.add(_this.new Coord(2, 5));
		
		objLst.forEach(ech -> System.out.println(ech));
		
		objLst.sort(SortObj::compare);
		System.out.println("after compare.....");
		objLst.forEach(ech -> System.out.println(ech));
	}
	
	public static int compare (Coord o1, Coord o2) {
		return o1.y < o2.y 
				? -1 : o1.y == o2.y 
						? o1.x < o2.x ? -1 : 0 
								: 0;
	}

	private class Coord{
		int x;
		int y;
		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public String toString()
		{
			return String.format("(x: %d, y: %d )", this.x, this.y);
		}
	}
}


