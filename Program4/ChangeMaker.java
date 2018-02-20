import java.util.Scanner;

public class ChangeMaker {

	public static void main(String[] args) {
		int k, n;
		int[] denominations, change;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of denominations & then their values in decreasing order:");
		k = in.nextInt();
		denominations = new int[k];
		change = new int[k];
		for (int i = 0; i < k; i++) {
			denominations[i] = in.nextInt();
		}
		System.out.println("Enter a value for n: (positive for change, 0 for quit) ");
		n = in.nextInt();
		while (n > 0) {
			change = change_DP(n, denominations);
			System.out.println("DP algorithm results");
		}
		
	}

	public static int[] change_DP(int n, int[] d) {
		int k = d.length;
		int[] c = new int[k];
		int[] a = new int[k];
		for (int j = 0; j <= k; j++) {
			c[j]
		}
	}
	
	private printSolution() {
		
	}
}
