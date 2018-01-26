public class MatrixProduct {

	public static int[][] matrixProduct_DAC(int[][] A, int[][] B) {
		if (!(A.length == A[0].length && B.length == B[0].length && A.length == B.length)) {
			throw new IllegalArgumentException();
		}
		double power = Math.log(A.length);
		if (power != Math.floor(power)) {
			throw new IllegalArgumentException();
		}
		
		//return MatrixProduct_DAC(int[][] A, int startrowA, int startcolA, int[][] B, int startrowB, int startcolB, int n);
	}
	
	private static int[][] MatrixProduct_DAC(int[][] A, int startrowA, int startcolA, int[][] B, int startrowB, int startcolB, int n) {
		int C[][] = new int[A.length][B.length];
		if (n == 1) {
			C[1][1] = A[startrowA][startcolA] * B[startrowB][startcolB];
		}
		else {
			int[][] c11, c12, c21, c22; 
			c11 = matrix_sum(MatrixProduct_DAC(A, 0, 0, B, 0, 0, n/2), MatrixProduct_DAC(A, 0, n/2 + 1, B, n/2 + 1, 0, n/2));
			c12 = matrix_sum(MatrixProduct_DAC(A, 0, 0, B, n/2 + 1, 0, n/2), MatrixProduct_DAC(A, n/2 + 1, 0, B, n/2 + 1, 0, n/2));
// add to row and col variables
			
			
		}
	}
	
	private static int[][] matrix_sum(int[][] A, int[][] B) {
		
	}
	

	
}
