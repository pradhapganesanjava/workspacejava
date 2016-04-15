package com.pg.java.bitwise;

/*
 * 
 // Multiplication
 	i * 8; // normal
 	i << 3; // bitwise [8 = 2^3, so use 3]

 // Division
 	i / 16; // normal
 	i >> 4; // bitwise [16 = 2^4, so use 4]

 // Modulus
 	i % 4; // normal
 	i & 3; // bitwise [4 = 1 << 2, apply ((1 << 2) - 1), so use 3]
 * 
 */
public class BitwiseOperatorsHello {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a = 4; 
		int b = 4; 
		int c = a&b;
		int d = a|b;
		int e = a^b;
		int f = ~a;
		int na = -7;
		int pa = 7;
		
		//add num of 0s to right and hense rest of bits moves to left.
		//left shift equivalent to multiply of 2
		int signedLeftShiftOperator = (na<<2); 
		
		//add num of 0s to right and hense rest of bits moves to left.
		//left shift equivalent to divide of 2
		int signedRightShiftOperator = (na>>2); 

		
		System.out.println("a: "+a+" bitwise value: "+Integer.toBinaryString(a));
		System.out.println("b: "+b+" bitwise value: "+Integer.toBinaryString(b));
		System.out.println("c = a&b : "+c+" bitwise value: "+Integer.toBinaryString(c));
		System.out.println("1|2: binary val "+Integer.toBinaryString(1|2)+" int val: "+(1|2));
		System.out.println("a | b : "+d+" bitwise value: "+Integer.toBinaryString(d));
		System.out.println("a^b : "+e+" bitwise value: "+Integer.toBinaryString(e));
		System.out.println("~a : "+f+" bitwise value: "+Integer.toBinaryString(f));
		
		System.out.println("na : "+na+" bitwise value: "+Integer.toBinaryString(na));
		System.out.println("na>>1 : "+(na>>1)+" bitwise value: "+Integer.toBinaryString(na>>1));
		System.out.println("na>>>1 : "+(na>>>1)+" bitwise value: "+Integer.toBinaryString(na>>>1));

		System.out.println("pa : "+pa+" bitwise value: "+Integer.toBinaryString(pa));
		System.out.println("pa>>1 : "+(pa>>1)+" bitwise value: "+Integer.toBinaryString(pa>>1));
		System.out.println("pa>>>1 : "+(pa>>>1)+" bitwise value: "+Integer.toBinaryString(pa>>>1));
		
		System.out.println("signedLeftShiftOperator na<<2 : "+(na<<2)+" bitwise value: "+Integer.toBinaryString(na<<2));
		System.out.println("signedRightShiftOperator na>>2 : "+(na>>2)+" bitwise value: "+Integer.toBinaryString(na>>2));
		
		System.out.println(" 29 - SPLIT NUMS as "+ (29/10)+ " : "+ (29%10));
		
		int cap = 11;
		int cap2 = 1;
		cap |= cap>>>1;
		System.out.println("cap: "+(cap));
		System.out.println(" "+(cap&cap2));
		System.out.println(" (cap >>> 1) "+(cap >>> 1));
		System.out.println(" cap "+cap);
		System.out.println(" cap |= (cap >>> 1) "+(cap |= (cap >>> 1)));
		System.out.println(" |&|"+(6&5));

		for(int i=1;i<17;i++){
			System.out.println(i+"&9)"+(i&9)+" ====> "+ "("+i+"|9) "+(i|9));
			//System.out.println("("+i+"|7)"+(i|7));
			//System.out.println("(7|"+i+")"+(7|i));
		}
		
	}

}
