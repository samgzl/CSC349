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
			
			
			System.out.println("Enter a value for n: (positive for change, 0 for quit) ");
			n = in.nextInt();
		}
		
	}

	public static int[] change_DP(int n, int[] d) {
		int k = d.length;
		int[] c = new int[n];
		int[] a = new int[n];
		for (int j = 0; j <= n; j++) {
			int min = Integer.MAX_VALUE;
			int savedI = -1;
			for (int i = 0; i < k; i++) {
				if (j == 0) {
					c[j] = 0;
				} else if ((j - d[i]) < 0) {
					c[j-d[i]] = Integer.MAX_VALUE;
				} else {
					if (c[j-d[i]] < min) {
						min = c[j-d[i]];
						savedI = i;
					}
				}
			}
			c[j] = 1 + min;
			a[j] = savedI;
		}
		printSolution(a);
		return c;
	}
	
	private static void printSolution(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		System.out.println();
	}
}
