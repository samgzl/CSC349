public class MatrixProductTest {

	@Test
	public void testDAC() {
		int[][] A = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
		int[][] B = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
		int C[][] = MatrixProduct.matrixProduct_DAC(A, B);
		for (int i=0; i<C.length; i++) {
			for (int j=0; j<C.length; j++) {
				//System.out.println(C[i][j]);
			}
		}
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testDACError() {
		int[][] A = {{1, 2, 3, 4}, {1, 2, 3, 4}};
		int[][] B = {{1, 2, 3, 4}, {1, 2, 3, 4}};
		int C[][] = MatrixProduct.matrixProduct_DAC(A, B);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDACError2() {
		int[][] A = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
		int[][] B = {{1, 2, 3}, {1, 2, 3}};
		int C[][] = MatrixProduct.matrixProduct_DAC(A, B);
	}
	
	@Test
	public void testS() {
		int[][] A = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
		int[][] B = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
		int C[][] = MatrixProduct.matrixProduct_Strassen(A, B);
		for (int i=0; i<C.length; i++) {
			for (int j=0; j<C.length; j++) {
				//System.out.println(C[i][j]);
			}
		}
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testSError() {
		int[][] A = {{1, 2, 3, 4}, {1, 2, 3, 4}};
		int[][] B = {{1, 2, 3, 4}, {1, 2, 3, 4}};
		int C[][] = MatrixProduct.matrixProduct_Strassen(A, B);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testS2Error() {
		int[][] A = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
		int[][] B = {{1, 2, 3}, {1, 2, 3}};
		int C[][] = MatrixProduct.matrixProduct_Strassen(A, B);
	}
	
	@Test
	public void testS2() {
		int[][] A = {{1, 2, 3, 4, 5, 6, 7, 8}, {1, 2, 3, 4, 5, 6, 7, 8}, {1, 2, 3, 4, 5, 6, 7, 8}, {1, 2, 3, 4, 5, 6, 7, 8}, {1, 2, 3, 4, 5, 6, 7, 8}, {1, 2, 3, 4, 5, 6, 7, 8}, {1, 2, 3, 4, 5, 6, 7, 8}, {1, 2, 3, 4, 5, 6, 7, 8}};
		int[][] B = {{8, 7, 6, 5, 4, 3, 2, 1}, {8, 7, 6, 5, 4, 3, 2, 1},  {8, 7, 6, 5, 4, 3, 2, 1},  {8, 7, 6, 5, 4, 3, 2, 1}, {8, 7, 6, 5, 4, 3, 2, 1}, {8, 7, 6, 5, 4, 3, 2, 1}, {8, 7, 6, 5, 4, 3, 2, 1}, {8, 7, 6, 5, 4, 3, 2, 1}};
		int C[][] = MatrixProduct.matrixProduct_Strassen(A, B);
		for (int i=0; i<C.length; i++) {
			for (int j=0; j<C.length; j++) {
				System.out.print(C[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testS3ERrror() {
		int[][] A = {};
		int[][] B = {{8, 7, 6, 5, 4, 3, 2, 1}, {8, 7, 6, 5, 4, 3, 2, 1},  {8, 7, 6, 5, 4, 3, 2, 1},  {8, 7, 6, 5, 4, 3, 2, 1}, {8, 7, 6, 5, 4, 3, 2, 1}, {8, 7, 6, 5, 4, 3, 2, 1}, {8, 7, 6, 5, 4, 3, 2, 1}, {8, 7, 6, 5, 4, 3, 2, 1}};
		int C[][] = MatrixProduct.matrixProduct_Strassen(A, B);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testDAC3ERrror() {
		int[][] A = {};
		int[][] B = {{8, 7, 6, 5, 4, 3, 2, 1}, {8, 7, 6, 5, 4, 3, 2, 1},  {8, 7, 6, 5, 4, 3, 2, 1},  {8, 7, 6, 5, 4, 3, 2, 1}, {8, 7, 6, 5, 4, 3, 2, 1}, {8, 7, 6, 5, 4, 3, 2, 1}, {8, 7, 6, 5, 4, 3, 2, 1}, {8, 7, 6, 5, 4, 3, 2, 1}};
		int C[][] = MatrixProduct.matrixProduct_DAC(A, B);

	}
	
	@Test
	public void testS4() {
		int[][] A = {{1, 0, 3, -4}, {1, 2, 3, 4}, {-1, 2, 3, 4}, {1, 0, 0, 0}};
		int[][] B = {{4, 3, 2, 1}, {4, -3, 2, 1}, {4, 3, 2, 1}, {-4, 3, -2, -1}};
		int C[][] = MatrixProduct.matrixProduct_Strassen(A, B);
		for (int i=0; i<C.length; i++) {
			for (int j=0; j<C.length; j++) {
				//System.out.print(C[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	@Test
	public void testDAC4() {
		int[][] A = {{1, 0, 3, -4}, {1, 2, 3, 4}, {-1, 2, 3, 4}, {1, 0, 0, 0}};
		int[][] B = {{4, 3, 2, 1}, {4, -3, 2, 1}, {4, 3, 2, 1}, {-4, 3, -2, -1}};
		int C[][] = MatrixProduct.matrixProduct_DAC(A, B);
		for (int i=0; i<C.length; i++) {
			for (int j=0; j<C.length; j++) {
				System.out.print(C[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testS4ERrror() {
		int[][] A = {{}};
		int[][] B = {{8, 7, 6, 5, 4, 3, 2, 1}, {8, 7, 6, 5, 4, 3, 2, 1},  {8, 7, 6, 5, 4, 3, 2, 1},  {8, 7, 6, 5, 4, 3, 2, 1}, {8, 7, 6, 5, 4, 3, 2, 1}, {8, 7, 6, 5, 4, 3, 2, 1}, {8, 7, 6, 5, 4, 3, 2, 1}, {8, 7, 6, 5, 4, 3, 2, 1}};
		int C[][] = MatrixProduct.matrixProduct_DAC(A, B);

	}
}
