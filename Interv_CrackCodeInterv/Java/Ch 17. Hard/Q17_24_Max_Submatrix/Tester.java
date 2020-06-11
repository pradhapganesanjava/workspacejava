package Q17_24_Max_Submatrix;

import CtCILibrary.AssortedMethods;

public class Tester {

	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(10, 10, -5, 5);
		matrix = new int[][] {
			{2,3,4,-5},
			{1,2,0,8},
			{-2,0,1,3},
			{4,-1,-2,8}
		};
		matrix = new int[][] {
			{5,1,2,5,2,-5,-1,5,-2,-4},
			{-2,0,-3,2,2,-5,-2,-1,-4,5},
			{4,3,0,2,-5,4,2,-5,2,-5},
			{5,-4,2,5,3,-1,-4,-4,-3,4},
			{-2,2,2,5,2,4,-1,3,-4,5},
			{2,-5,0,-4,2,3,4,-5,5,-4},
			{1,1,4,-1,-5,3,-3,-3,4,2},
			{-3,3,1,-1,-1,3,5,-4,-2,0},
			{-2,-4,-3,2,4,-3,1,3,1,-5},
			{-2,-4,4,5,5,-5,-5,1,5,-2}
		};
		AssortedMethods.printMatrix(matrix);
		SubMatrix subA = QuestionA.getMaxMatrix(matrix);
		System.out.println(subA.toString());
		
		SubMatrix subB = QuestionB.getMaxMatrix(matrix);
		System.out.println(subB.toString());
		
		SubMatrix subC = QuestionC.getMaxMatrix(matrix);
		System.out.println(subC.toString());	
	}

}
