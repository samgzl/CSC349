

public class MatrixProduct {
	
	public static void main(String args[]) {
		int[][] A = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
		int[][] B = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
		int C[][] = matrixProduct_DAC(A, B);
		for (int i=0; i<C.length; i++) {
			for (int j=0; j<C.length; j++) {
				System.out.println(C[i][j]);
			}
		}

	}

	public static int[][] matrixProduct_DAC(int[][] A, int[][] B) {
		if (!(A.length == A[0].length && B.length == B[0].length && A.length == B.length)) {
			throw new IllegalArgumentException();
		}
		double power = (Math.log(A.length)/Math.log(2));
		if (power != Math.floor(power)) {
			throw new IllegalArgumentException();
		}
		return MatrixProduct_DAC(A, 0, 0, B, 0, 0, A.length);
	}
	
	private static int[][] MatrixProduct_DAC(int[][] A, int startrowA, int startcolA, int[][] B, int startrowB, int startcolB, int n) {
		int C[][] = new int[A.length][B.length];
		if (n == 1) {
			C[0][0] = A[startrowA][startcolA] * B[startrowB][startcolB];
		}
		else {
			int[][] c11, c12, c21, c22; 
			c11 = matrix_sum(MatrixProduct_DAC(A, startrowA, startcolA, B, startrowB, startcolB, n/2), MatrixProduct_DAC(A, startrowA, startcolA + n/2, B, startrowB + n/2, startcolB, n/2));
			c12 = matrix_sum(MatrixProduct_DAC(A, startrowA, startcolA, B, startrowB, startcolB + n/2, n/2), MatrixProduct_DAC(A, startrowA, startcolA + n/2, B, startrowB + n/2, startcolB + n/2, n/2));
			c21 = matrix_sum(MatrixProduct_DAC(A, startrowA + n/2, startcolA, B, startrowB, startcolB, n/2), MatrixProduct_DAC(A, startrowA + n/2, startcolA + n/2, B, startrowB + n/2, startcolB, n/2));
			c22 = matrix_sum(MatrixProduct_DAC(A, startrowA + n/2, startcolA, B, startrowB, startcolB + n/2, n/2), MatrixProduct_DAC(A, startrowA + n/2, startcolA + n/2, B, startrowB + n/2, startcolB + n/2, n/2));
			for (int i=0; i<n/2; i++) {
				for (int j=0; j<n/2; j++) {
					C[i][j] = c11[i][j];
				}
			}
			for (int i=0; i<n/2; i++) {
				for (int j=n/2; j<n; j++) {
					C[i][j] = c12[i][j-(n/2)];
				}
			}
			for (int i=n/2; i<n; i++) {
				for (int j=0; j<n/2; j++) {
					C[i][j] = c21[i-(n/2)][j];
				}
			}
			for (int i=n/2; i<n; i++) {
				for (int j=n/2; j<n; j++) {
					C[i][j] = c22[i-(n/2)][j-(n/2)];
				}
			}
			
		}
		return C;
	}
	
	private static int[][] matrix_sum(int[][] A, int[][] B) {
		int C[][] = new int[A.length][A.length];
		for (int i=0; i<A.length; i++) {
			for (int j=0; j<B.length; j++) {
				C[i][j] = A[i][j] + B[i][j];
			}
		}
		return C;
	}
	

	
}
