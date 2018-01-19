import static org.junit.Assert.*;

import org.junit.Test;

public class SortTests {

	@Test
	public void testSelectionSort() {
		int[] arr = {-90, 40, 30, 2, 8, 10};
		Sorts.selectionSort(arr, arr.length);
		int[] arr2 = {-90, 2, 8, 10, 30, 40};
		assertArrayEquals(arr, arr2);
	}
	
	@Test
	public void testSelectionSort2() {
		int[] arr = {-0, -10, -3};
		Sorts.selectionSort(arr, arr.length);
		int[] arr2 = {-10, -3, -0};
		assertArrayEquals(arr, arr2);
	}
	
	@Test
	public void testSelectionSort3() {
		int[] arr = {-90, 40, 30, 2, 8, 10, -25, 8, 100, 100, 100};
		Sorts.selectionSort(arr, arr.length);
		int[] arr2 = {-90, -25, 2, 8, 8, 10, 30, 40, 100, 100, 100};
		assertArrayEquals(arr, arr2);
	}
	
	@Test
	public void testMergeSort() {
		int[] arr = {-90, 40, 30, 2, 8, 10, -25, 8, 100, 100, 100};
		Sorts.mergeSort(arr, arr.length);
		int[] arr2 = {-90, -25, 2, 8, 8, 10, 30, 40, 100, 100, 100};
		assertArrayEquals(arr2, arr);
	}
	
	@Test
	public void testMergeSort2() {
		int[] arr = {90};
		Sorts.mergeSort(arr, arr.length);
		int[] arr2 = {90};
		assertArrayEquals(arr2, arr);
	}
	
	@Test
	public void testQuickSort() {
		int[] arr = {-90, 40, 30, 2, 8, 10, -25, 8, 100};
		Sorts.quickSort(arr, arr.length);
		int[] arr2 = {-90, -25, 2, 8, 8, 10, 30, 40, 100};
		assertArrayEquals(arr2, arr);
	}
	
	@Test
	public void testQuickSort2() {
		int[] arr = {-90, 40, 100, 30, 2, 8, 10, -25, 8, 100};
		Sorts.quickSort(arr, arr.length);
		int[] arr2 = {-90, -25, 2, 8, 8, 10, 30, 40, 100, 100};
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		assertArrayEquals(arr2, arr);
	}
	
	@Test
	public void testQuickSort3() {
		int[] arr = {-50, 10, 0, 3, -51, 10, 10};
		Sorts.quickSort(arr, arr.length);
		int[] arr2 = {-51, -50, 0, 3, 10, 10, 10};
		assertArrayEquals(arr2, arr);
	}
	
	@Test
	public void testQuickSort4() {
		int[] arr = {5, 0, 5, 0};
		Sorts.quickSort(arr, arr.length);
		int[] arr2 = {0, 0, 5, 5};
		assertArrayEquals(arr2, arr);
	}
}
