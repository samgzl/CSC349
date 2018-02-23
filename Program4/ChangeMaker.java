
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
			System.out.println("Amount: " + n);
			System.out.print("Optimal distribution: ");
			int last = 0;
			for (int i=0; i<k; i++) {
				if (change[i] != 0) {
					last = i;
				}
			}
			int count = 0;
			for (int i=0; i<k; i++) {
				if (change[i] == 0) {
					continue;
				}
				System.out.print(change[i] + "*" + denominations[i] + "c");
				count += change[i];
				if (i != last) {
					System.out.print(" + ");
				}
			}
			System.out.println();
			System.out.println("Optimal coin count: " + count);
			System.out.println();
			System.out.println("Enter a value for n: (positive for change, 0 for quit) ");
			n = in.nextInt();
		}
		
	}

	public static int[] change_DP(int n, int[] d) {
		int k = d.length;
		int[] c = new int[n+1];
		int[] a = new int[n+1];
		for (int j = 1; j < n+1; j++) {
			int min = Integer.MAX_VALUE;
			int savedI = -1;
			for (int i = 0; i < k; i++) {
				if ((j - d[i]) < 0) {
					continue;
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
		int[] b = getSolution(a, n, d);
		return b;
	}
	
	private static int[] getSolution(int[] a, int n, int[] d) {
		int i;
		int[] b = new int[d.length];
		while (n > 0) {
			i = n;
			n = n - d[a[i]];
			b[a[i]] += 1;		
		}
		return b;
		
	}
}
