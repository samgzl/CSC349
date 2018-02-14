import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameProblem {

	public static void main() throws FileNotFoundException {
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

		
		for (int i=n-1; i>=0; i--) {
			for (int j=m-1; j >= 0; j--) {
				if (i == n-1 && j == m-1) {
					S[i][j] = A[n-1][m-1];
				}
				else if (j == m-1) {
					S[i][j] = Math.max(S[i+1][m-1], 0) + A[i][j];
				}
				else if (i == n-1) {
					S[i][j] = Math.max(S[n-1][j+1], 0) + A[i][j];
				}
				else {
					S[i][j] = Math.max(S[i+1][j], S[i][j+1]) + A[i][j];
				}
			}
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				System.out.print(S[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}
	
	
}
