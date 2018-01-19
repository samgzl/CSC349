import java.util.Random;

public class SortCounts {
	
	public static void main(String[] args) {
		
		int[] arr1 = new int[12800];
		int[] arr2 = new int[12800];
		int[] arr3 = new int[12800];
		
		long ss_avg = 0;
		long ms_avg = 0;
		long qs_avg = 0;
		
		Random rand = new Random();
		
		for (int N=100; N<=12800; N*=2) {
			ss_avg = 0;
			ms_avg = 0;
			qs_avg = 0;
			for (int j=0; j<100; j++) {
				
				for (int i=0; i<N; i++) {
					int random = rand.nextInt();
					arr1[i] = random;
					arr2[i] = random;
					arr3[i] = random;
				}	
				
				ss_avg += Sorts1.selectionSort(arr1, N);
				ms_avg += Sorts1.mergeSort(arr2, N);
				qs_avg += Sorts1.quickSort(arr3, N);

			}
			ss_avg = ss_avg/100;
			ms_avg = ms_avg/100;
			qs_avg = qs_avg/100;
			System.out.println("N = " + N + ": C_ss = " + ss_avg +", C_ms = " + ms_avg + ", C_qs = " + qs_avg);
		}
		
		
		
	}
	
	
	
	
	
	
}
