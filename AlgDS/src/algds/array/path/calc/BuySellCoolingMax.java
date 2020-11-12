package algds.array.path.calc;

import java.util.HashMap;
import java.util.Map;

public class BuySellCoolingMax {

	public static void main(String[] args) {
		BuySellCoolingMax_Solution sol = new BuySellCoolingMax_Solution();
		int mxProf = sol.maxProfit(new int[] {2,0,-1,4,5,1,2});
		System.out.println(mxProf);
		
	}

}

class BuySellCoolingMax_Solution {
	public int maxProfit(int[] prices) {
		// return dp(prices);
		// return recurMem(prices);
		return recur(prices);
	}

	private int recurMem(int[] nums) {
		Map<Integer, Integer> buyMp = new HashMap<>();
		Map<Integer, Integer> sellMp = new HashMap<>();
		return buy(nums, 0, buyMp, sellMp);
	}

	private int buy(int[] nums, int i, Map<Integer, Integer> buyMp, Map<Integer, Integer> sellMp) {
		if (i >= nums.length) {
			return 0;
		}
		if (buyMp.containsKey(i)) {
			return buyMp.get(i);
		}
		buyMp.put(i, Math.max(buy(nums, i + 1, buyMp, sellMp), -nums[i] + sell(nums, i + 1, buyMp, sellMp)));
		return buyMp.get(i);
	}

	private int sell(int[] nums, int i, Map<Integer, Integer> buyMp, Map<Integer, Integer> sellMp) {
		if (i >= nums.length) {
			return 0;
		}
		if (sellMp.containsKey(i)) {
			return sellMp.get(i);
		}
		sellMp.put(i, Math.max((nums[i] + buy(nums, i + 2, buyMp, sellMp)), sell(nums, i + 1, buyMp, sellMp)));
		return sellMp.get(i);
	}

	/*-----------------------------------------------------------------------------------------------------------
	 ---- Simple -- 
	  ------------------------------------------------------------------------------------------------------------*/
	private int recur(int[] nums) {
		return buy(nums, 0);
	}

	private int buy(int[] nums, int i) {
		if (i >= nums.length) {
			return 0; }
		return Math.max( buy(nums, i + 1),  sell(nums, i + 1) - nums[i]);
	}

	private int sell(int[] nums, int i) {
		if (i >= nums.length) {
			return 0; }
		return Math.max( (nums[i] + buy(nums, i + 2)), sell(nums, i + 1));
	}

}