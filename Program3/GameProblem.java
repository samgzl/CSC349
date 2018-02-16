import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameProblem {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter file name: ");
		File input = new File(in.next());
		// Parse file, store data in variables
		Scanner file = new Scanner(input);
		int rows = file.nextInt();
		int cols = file.nextInt();
		int[][] board = new int[rows][cols];
		for (int i=0; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				board[i][j] = file.nextInt();
			}
		}
		
		game(rows, cols, board);
		
	}
	
	
	public static void game(int n, int m, int[][] A) {
		int[][] S = new int[n][m];
		int[][] R = new int[n][m];

		// bottom corner piece
		S[n-1][m-1] = A[n-1][m-1];
		
		// fill bottom row 
		for (int j=m-2; j>=0; j--) {
			if (S[n-1][j+1] >= 0) {
				R[n-1][j] = 'r';
				S[n-1][j] = S[n-1][j+1] + A[n-1][j];
			}
			else  {
				R[n-1][j] = 'e';
				S[n-1][j] = A[n-1][j];
			}
		}

		// fill right-most column
		for (int i=n-2; i >= 0; i--) {
			if (S[i+1][m-1] >= 0) {
				R[i][m-1] = 'd';
				S[i][m-1] = S[i+1][m-1] + A[i][m-1];
			}
			else {
				R[i][m-1] = 'e';
				S[i][m-1] = A[i][m-1];
			}
		}
		
		// fill in rest
		for (int i=n-2; i>=0; i--) {
			for (int j=m-2; j >= 0; j--) {
				if (S[i+1][j] >= S[i][j+1]) {
					R[i][j] = 'd';
					S[i][j] = S[i+1][j] + A[i][j];
				}
				else {
					R[i][j] = 'r';
					S[i][j] = S[i][j+1] + A[i][j];
				}
			}
		}	
		
		/*
		for (int i=n-1; i>=0; i--) {
			for (int j=m-1; j >= 0; j--) {
				if (i == n-1 && j == m-1) {
					S[i][j] = A[n-1][m-1];
				}
				else if (j == m-1) {
					if (S[i+1][m-1] >= 0) {
						R[i][j] = 'd';
						S[i][j] = S[i+1][m-1] + A[i][j];
					}
					else {
						R[i][j] = 'e';
						S[i][j] = A[i][j];
					}
					//S[i][j] = Math.max(S[i+1][m-1], 0) + A[i][j];
				}
				else if (i == n-1) {
					if (S[n-1][j+1] >= 0) {
						R[i][j] = 'r';
						S[i][j] = S[n-1][j+1] + A[i][j];
					}
					else  {
						R[i][j] = 'e';
						S[i][j] = A[i][j];
					}
					//S[i][j] = Math.max(S[n-1][j+1], 0) + A[i][j];
				}
				*/
		
		// Find i,j of max value in S
		int iMax = -1000; 
		int jMax = -1000;
		int max = -1000;
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (S[i][j] > max) {
					max = S[i][j];
					iMax = i;
					jMax = j;
				}
				System.out.print(S[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("Best score: " + S[iMax][jMax]);
		printOptimalRoute(iMax, jMax, R);
	}
	
	private static void printOptimalRoute(int iMax, int jMax, int[][] R) {
		int i = iMax;
		int j = jMax;
		System.out.print("Best route: ");
		while (R[i][j] != 'e') {
			System.out.print("[" + (i+1) + "," + (j+1) + "] to ");
			if (R[i][j] == 'r') {
				j++;
			} 
			else if (R[i][j] == 'd') {
				i++;
			}
		}
		System.out.print("exit");
		System.out.println("");
	}
	
}
