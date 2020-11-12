package solstools.math.xor;

public class MaxDiffNumsXor {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8,9,10,12,23,44,55,100,122};
		
		for(int i=0; i<nums.length; i++) {
			for(int j=i; j<nums.length; j++) {
				System.out.format("(%d ^ %d) = %d \n", nums[i], nums[j], (nums[i]^nums[j]));
			}
		}
	}

}
