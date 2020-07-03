package solstools.bit.repeat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
	<a href="https://leetcode.com/problems/prison-cells-after-n-days/>957. Prison Cells After N Days</a>
	
	There are 8 prison cells in a row, and each cell is either occupied or vacant.

	Each day, whether the cell is occupied or vacant changes according to the following rules:
	
	If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
	Otherwise, it becomes vacant.
	(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)
	
	We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.
	
	Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)
	
	Example 1:
	Input: cells = [0,1,0,1,1,0,0,1], N = 7
	Output: [0,0,1,1,0,0,0,0]
	Explanation: 
	The following table summarizes the state of the prison on each day:
	Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
	Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
	Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
	Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
	Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
	Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
	Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
	Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
	
	Example 2:
	Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
	Output: [0,0,1,1,1,1,1,0]

 */
/*
 *  	fast-forward strategy
 	Keys:
 		> Bits REPEAT patterns after a cycle
 		> After N days, N is inclusive or exclusive? 
 		>....Given day start 0, N is inclusive.

 	Time : O(K * min(N,2^K) )  //K is Number of Cells; 2 pow K is Max possible unique
 	Space: O(2^K)
 		
 */
public class PrisonCellsAfterNDays {

	public static void main(String[] args) {

	}

}

class PrisonCellsAfterNDays_Solution {
	public int[] prisonAfterNDays(int[] cells, int N) {
		return findCycleRecur(cells, N);
	}

	private int[] findCycleRecur(int[] cells, int n) {
		Map<String, Integer> mp = new HashMap<>();
		return findCycleRecur(cells, n, mp);
	}

	private int[] findCycleRecur(int[] cells, int n, Map<String, Integer> mp) {
		if (mp.containsKey(Arrays.toString(cells))) {
			int pn = mp.get(Arrays.toString(cells));
			int dif = pn - n;
			n %= dif;
		} else {
			mp.put(Arrays.toString(cells), n);
		}
		if (n == 0) {
			return cells;
		}
		return findCycleRecur(nextDay(cells), n - 1, mp);
	}

	private int[] findCycle(int[] cells, int n) {
		Map<String, Integer> mp = new HashMap<>();
		int[] nxtDay = cells;
		while (n > 0) {
			String scells = Arrays.toString(nxtDay);
			if (mp.containsKey(scells)) {
				int pn = mp.get(scells);
				int dif = pn - n;
				if (n > dif && dif > 0) {
					int t = (int) (n / dif);
					// n -= (t*dif)
					n %= dif;
				}
			}
			mp.put(scells, n);
			nxtDay = nextDay(cells);
			n--;
		}
		return nxtDay;
	}

	private int[] nextDay(int[] cells) {
		int[] nxtDay = new int[cells.length];
		// nxtDay[0] = cells[0];
		// nxtDay[cells.length-1] = cells[cells.length-1];
		for (int i = 1; i < cells.length - 1; i++) {
			if (cells[i - 1] == cells[i + 1]) {
				nxtDay[i] = 1;
			} else {
				nxtDay[i] = 0;
			}
		}
		return nxtDay;
	}
}
