package solstools.array.bisearch;

public class FindBlankInArray {

	public static void main(String[] args) {
		String s = "leetcode";
		int blankIdx = bisrch(s.toCharArray(), 5);
		// System.out.format("Blank idx: %d, last char: %c \n", blankIdx, ((blankIdx-1)>-1 ? s.charAt(blankIdx-1):'\u0000'));
		System.out.format("Blank idx: %d, last char: %c \n", blankIdx, s.charAt(blankIdx));
	}

    private static int bisrch(char[] buf, int n){
        int s = 0;
        int e = n;
        while(s < e){
           int m = s + (e-s)/2; 
           if(Character.isWhitespace(buf[m])){
               e = m;
           }else{
               s = m+1;
           }
        }
        return s;
    }
}
