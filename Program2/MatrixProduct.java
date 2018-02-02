
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
	
	public static int[][] matrixProduct_Strassen(int[][] A, int[][] B) {
		if (!(A.length == A[0].length && B.length == B[0].length && A.length == B.length)) {
			throw new IllegalArgumentException();
		}
		double power = (Math.log(A.length)/Math.log(2));
		if (power != Math.floor(power)) {
			throw new IllegalArgumentException();
		}
		return MatrixProduct_DAC(A, 0, 0, B, 0, 0, A.length);
		
		
		
	}
	
	private static int[][] MatrixProduct_Strassen(int[][] A, int startrowA, int startcolA, int[][] B, int startrowB, int startcolB, int n) {
		int C[][] = new int[A.length][B.length];
		if (n == 1) {
			C[0][0] = A[startrowA][startcolA] * B[startrowB][startcolB];
		}
		else {
			int[][] c11, c12, c21, c22, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, p1, p2, p3, p4, p5, p6, p7; 
			int[][] c11temp1, c11temp2, c22temp1, c22temp2;
			s1 = matrix_diff_strassen(B, startrowB, startcolB + (n/2), B, startrowB + (n/2), startcolB + (n/2), n/2);
			s2 = matrix_sum_strassen(A, startrowA, startcolA, A, startrowA, startcolA + (n/2), n/2);
			s3 = matrix_sum_strassen(A, startrowA + (n/2), startcolA, A, startrowA + (n/2), startcolA + (n/2), n/2);
			s4 = matrix_diff_strassen(B, startrowB + (n/2), startcolB, B, startrowB, startcolB, n/2);
			s5 = matrix_sum_strassen(A, startrowA, startcolA, A, startrowA + (n/2), startcolA + (n/2), n/2);
			s6 = matrix_sum_strassen(B, startrowB, startcolB, B, startrowB + (n/2), startcolB + (n/2), n/2);
			s7 = matrix_diff_strassen(A, startrowA, startcolA + (n/2), A, startrowA + (n/2), startcolA + (n/2), n/2);
			s8 = matrix_sum_strassen(B, startrowB + (n/2), startcolB, B, startrowB + (n/2), startcolB + (n/2), n/2);
			s9 = matrix_diff_strassen(A, startrowA, startcolA, A, startrowA + (n/2), startcolA, n/2);
			s10 = matrix_sum_strassen(B, startrowB, startcolB, B, startrowB, startcolB + (n/2), n/2);
			
			p1 = MatrixProduct_Strassen(A, startrowA, startcolA, s1, 0, 0, n/2);
			p2 = MatrixProduct_Strassen(s2, 0, 0, B, startrowB + (n/2), startcolB + (n/2), n/2);
			p3 = MatrixProduct_Strassen(s3, 0, 0, B, startrowB, startcolB, n/2);
			p4 = MatrixProduct_Strassen(A, startrowA + (n/2), startcolA + (n/2), s4, 0, 0, n/2);
			p5 = MatrixProduct_Strassen(s5, 0, 0, s6, 0, 0, n/2);
			p6 = MatrixProduct_Strassen(s7, 0, 0, s8, 0, 0, n/2);
			p7 = MatrixProduct_Strassen(s9, 0, 0, s10, 0, 0, n/2);
			
			c11temp1 = matrix_sum_strassen(p5, 0, 0, p4, 0, 0, n/2);
			c11temp2 = matrix_sum_strassen(p2, 0, 0, p6, 0, 0, n/2);
			c11 = matrix_diff_strassen(c11temp1, 0, 0, c11temp2, 0, 0, n/2);
			
			c12 = matrix_sum_strassen(p1, 0, 0, p2, 0, 0, n/2);
			
			c21 = matrix_sum_strassen(p3, 0, 0, p4, 0, 0, n/2); 
			
			c22temp1 = matrix_sum_strassen(p5, 0, 0, p1, 0, 0, n/2);
			c22temp2 = matrix_sum_strassen(p2, 0, 0, p6, 0, 0, n/2);
			c22 = matrix_diff_strassen(c11temp1, 0, 0, c11temp2, 0, 0, n/2);
			
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
	
	private static int[][] matrix_sum_strassen(int[][] A, int startrowA, int startcolA, int[][] B, int startrowB, int startcolB, int n) {
		int C[][] = new int[A.length][A.length];
		int k, l;
		k = startrowB;
		l = startcolB;
		for (int i=startrowA; i<n; i++) {
			if (k == n) {
				k = 0;
			}
			for (int j=startcolA; j<n; j++) {
				if (l == n) {
					l = 0;
				}
				C[i][j] = A[i][j] + B[k][l];
				l++;
			}
			k++;
		}
		return C;
	}
	
	private static int[][] matrix_diff_strassen(int[][] A, int startrowA, int startcolA, int[][] B, int startrowB, int startcolB, int n) {
		int C[][] = new int[A.length][A.length];
		int k, l;
		k = startrowB;
		l = startcolB;
		for (int i=startrowA; i<n; i++) {
			if (k == n) {
				k = 0;
			}
			for (int j=startcolA; j<n; j++) {
				if (l == n) {
					l = 0;
				}
				C[i][j] = A[i][j] - B[k][l];
				l++;
			}
			k++;
		}
		return C;
	}
	
}

