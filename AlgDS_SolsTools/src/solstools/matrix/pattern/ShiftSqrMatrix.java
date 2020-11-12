package solstools.matrix.pattern;

public class ShiftSqrMatrix {

	public static void main(String[] args) {
		int[][] a = {
						{1,2,3,4 },
						{5,6,7,8 },
						{9,10,11,12 },
						{13,14,15,16 }
					};
		int[][] b = {
						{-1,-2,-3,-4 },
						{-5,-6,-7,-8 },
						{-9,-10,-11,-12 },
						{-13,-14,-15,-16 }
					};		
		
		int n = a.length;
		for(int ra= -(n-1); ra < n; ra++) {
			for(int ca = -(n-1); ca < n; ca++) {
				
				for(int rb = 0; rb < n; rb++) {
					for( int cb = 0; cb < n; cb++) {
						
						if( ra + rb < 0 || ra + rb >= n || ca + cb < 0 || ca + cb >= n) {
							System.err.format(" b(%d, %d) a(%d, %d) a+b(%d, %d) \n",rb, cb, ra, ca, (ra+rb), (ca+cb));
							continue;
						}
						System.out.format(" b(%d, %d)=%d, a(%d, %d)=%d,  a+b(%d, %d)=%d \n",rb, cb, b[rb][cb], ra, ca, a[ra+rb][ca+cb], (ra+rb), (ca+cb),(b[rb][cb]+a[ra+rb][ca+cb]));
					}
				}
				
			}
		}
	}

}
