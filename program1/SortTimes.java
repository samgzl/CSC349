import java.util.Random;

public class SortTimes {

	public static void main(String[] args) {
		
		int[] list1 = new int[160000];
		int[] list2 = new int[160000];
		int[] list3 = new int[160000];

		Random rand = new Random();
		
		for (int N=5000; N<=160000; N*=2) {
			for (int j=0; j<5; j++) {
				
				for (int i=0; i<N; i++) {
					int random = rand.nextInt();
					list1[i] = random;
					list2[i] = random;
					list3[i] = random;
				}	
				long start = System.nanoTime();
				Sorts.selectionSort(list1, N);
				long end = System.nanoTime();
				int ss_time = (int) ((end - start) / 1000000);
				start = System.nanoTime();
				Sorts.mergeSort(list2, N);
				end = System.nanoTime();
				int ms_time = (int) ((end - start) / 1000000);
				start = System.nanoTime();
				Sorts.quickSort(list3, N);
				end = System.nanoTime();
				int qs_time = (int) ((end - start) / 1000000);
				System.out.println("N = " + N + ": T_ss = " + ss_time + ", T_ms = "+ ms_time + ", T_qs = " + qs_time);
			}
			System.out.println();
		}
		
		
		
		
		
	}
	
	
	
}
