import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FactoryProblem {

	
	public static void main(String[] args) throws FileNotFoundException {
		// Prompt for file
		Scanner in = new Scanner(System.in);
		System.out.println("Enter file name: ");
		File input = new File(in.next());
		// Parse file, store data in variables
		Scanner file = new Scanner(input);
		int n = file.nextInt(); // # of stations
		int e1 = file.nextInt(); // entry time 1
		int e2 = file.nextInt(); // entry time 2
		int x1 = file.nextInt(); // exit time 1
		int x2 = file.nextInt(); // exit time 2
		int a1[] = new int[n]; // time at A1,j station
		int a2[] = new int[n]; // time at A2,j station
		int t1[] = new int[n-1]; // time from assemb. line 1 station j -> assemb. line 2 station j+1
		int t2[] = new int[n-1]; // time from assemb. line 2 station j -> assemb. line 1 station j+1
		for (int i=0; i<n; i++) {
			a1[i] = file.nextInt();
		}
		for (int i=0; i<n; i++) {
			a2[i] = file.nextInt();
		}
		for (int i=0; i<n-1; i++) {
			t1[i] = file.nextInt();
		}
		for (int i=0; i<n-1; i++) {
			t2[i] = file.nextInt();
		}
		findOptimalPath(n, e1, e2, x1, x2, a1, a2, t1, t2);

	}
	
	static void findOptimalPath(int n, int e1, int e2, int x1, int x2, int a1[], int[] a2, int[] t1, int[] t2) {
		int[] f1 = new int[n];
		int[] f2 = new int[n];
		int[][] l = new int[n+1][n+1];
		f1[0] = e1 + a1[0]; // j = 0
		f2[0] = e2 + a2[0]; // j = 0
		// compute f values
		for (int j=1; j<n; j++) {
			f1[j] = Math.min(f1[j-1] + a1[j], f2[j-1] + t2[j-1] + a1[j]);
			if (f1[j] == f1[j-1] + a1[j]) {
				l[0][j+1] = 0;
			}
			else {
				l[0][j+1] = 1;
			}
			f2[j] = Math.min(f2[j-1] + a2[j], f1[j-1] + t1[j-1] + a2[j]);	
			if (f2[j] == f2[j-1] + a2[j]) {
				l[1][j+1] = 1;
			}
			else {
				l[1][j+1] = 0;
			}
		}
		// compute f*
		int f_star = 0;
		int l_star = 0;
		if (f1[n-1] < f2[n-1]) {
			f_star = f1[n-1] + x1;
			l_star = 0;
		}
		else if (f1[n-1] > f2[n-1]) {
			f_star = f2[n-1] + x2;
			l_star = 1;
		}
		else { // f1 == f2
			if (x1 < x2) {
				f_star = f1[n-1] + x1;
				l_star = 0;
			}
			else {
				f_star = f2[n-1] + x2;
				l_star = 1;
			}
		}
		printSolution(f_star, l_star, n, l);
	}
	
	public static void printSolution(int f_star, int l_star, int station, int[][] l) {
		System.out.println("Fastest time is: " + f_star);
		System.out.println();
		System.out.println("The optimal route is:");
		if (l_star == 0) {
			printSolutionRecursive(0, station, l);		
		}
		else {	
			printSolutionRecursive(1, station, l);		
		}
		System.out.println("station " + station + ", line " + (l_star+1));
	}
	
	
	private static void printSolutionRecursive(int line, int station, int[][] l) {
		if (station < 2) {
			return;
		}
		if (station == 2) {
			System.out.println("station " + (station-1) + ", line " + (l[line][station]+1));
		}
		else {
			if (l[line][station] == 0) {
				printSolutionRecursive(0, station-1, l);	
			}
			else {
				printSolutionRecursive(1, station-1, l);
			}
			System.out.println("station " + (station-1) + ", line " + (l[line][station]+1));
		}
	}

}
