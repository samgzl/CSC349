public class Sorts {

	public static void selectionSort (int[] arr, int N) {
		int minIndex;
		for (int i=0; i<N; i++) {
			minIndex = i;
			for (int j=i+1; j<N; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}	
	}
	
	public static void mergeSort(int[] list, int N) {
		mergeSort(list, 0, N-1);
	}
	
	private static void mergeSort(int[] list, int first, int last) {
		if (first < last) {
			int middle = (first + last) / 2;
			mergeSort(list, first, middle);
			mergeSort(list, middle+1, last);
			mergeSortedHalves(list, first, middle, last);
		}
		return;
	}
	
	 private static void mergeSortedHalves (int[] arr, int left, int middle, int right) {
		 int[] temp = new int[(right - left + 1)]; 
		 int index1 = left;
		 int index2 = middle+1;
		 int index = 0;
		 while (index1 < middle + 1 && index2 <= right) {
			 if (arr[index1] <= arr[index2]) {
				 temp[index] = arr[index1];
				 index1++;
			 }
			 else {
				 temp[index] = arr[index2];
				 index2++;
			 }
			 index++;
		 }
		 
		 while (index1 < middle + 1) {
			 temp[index] = arr[index1];
			 index1++;
	  		 index++;
		 }
		 
		 while (index2 <= right) {
			 temp[index] = arr[index2];
			 index2++;
			 index++;
		 }
		 
		 int j=0;
		 for (int i=left; i<=right; i++) {
			 arr[i] = temp[j];
			 j++;
		 }
	 }
	
	
	
}
