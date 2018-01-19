
public class Sorts1 {

	public static long selectionSort (int[] arr, int N) {
		long count = 0;
		int minIndex;
		for (int i=0; i<N-1; i++) {
			minIndex = i;
			for (int j=i+1; j<N; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
				count++;
			}
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
		return count;
	}
	
	public static long mergeSort(int[] list, int N) {
		mergeSort(list, 0, N-1);
		 long ret_val = count.merge_count;
		 count.merge_count = 0;
		return ret_val;
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
			 count.merge_count++;
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
	
	 public static long quickSort (int[] arr, int N) {
		 quickSort(arr, 0, N-1);
		 long ret_val = count.quick_count;
		 count.quick_count = 0;
		 return ret_val;
	 }
	 
	 private static void quickSort (int[] list, int first, int last) {
		 if (first < last) {
			 setPivotToEnd(list, first, last);
			 int pivotIndex = splitList(list, first, last);
			 quickSort(list, first, pivotIndex-1);
			 quickSort(list, pivotIndex+1, last);
		 } 
		 
	 }
	 
	 private static void setPivotToEnd (int[] arr, int left, int right) {
		 int center = (left+right)/2;		 
		 if (arr[right] < arr[left]) {
			 int temp = arr[left];
			 arr[left] = arr[right];
			 arr[right] = temp;
		 }
		 if (arr[center] < arr[left]) {
			 int temp = arr[center];
			 arr[center] = arr[left];
			 arr[left] = temp;
		 }
		 if (arr[right] > arr[center]) {
			 int temp = arr[center];
			 arr[center] = arr[right];
			 arr[right] = temp;
		 }
		 count.quick_count += 3;  
		 
	 }
	 
	 private static int splitList (int[] arr, int left, int right) {
		 int indexL = left;
		 int indexR = right-1;
		 while (indexL <= indexR) {
			 while (arr[indexL] < arr[right]) {
				 indexL++;
				 count.quick_count++;
			 }
			 count.quick_count++;
			 while (indexL <= indexR) {
				 if (arr[indexR] > arr[right]) {
					 indexR--;
					 count.quick_count++;
				 }
				 else {
					 count.quick_count++;
					 break;
				 }
			 } 
			 if (indexL <= indexR) {
				 int temp = arr[indexR];
				 arr[indexR] = arr[indexL];
				 arr[indexL] = temp;
				 indexL++;
				 indexR--;
			 }
		 }
		 int temp = arr[indexL];
		 arr[indexL] = arr[right]; //swap with pivot
		 arr[right] = temp;
		 return indexL; //new pivot location
	 }
	
	private static class count {
		public static long merge_count = 0;
		public static long quick_count = 0;
	}
	
	
}
