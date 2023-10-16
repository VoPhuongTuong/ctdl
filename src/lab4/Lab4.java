package lab4;

import java.util.Arrays;

public class Lab4 {
	//Task1.1
	public static void selectionSort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			int maxIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (array[j] > array[maxIndex]) {
					maxIndex = j;
				}
			}
			int temp = array[i];
			array[i] = array[maxIndex];
			array[maxIndex] = temp;
		}
	}
	public static void inMang(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	//Task1.2
	public static void bubbleSort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (array[j] < array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}
	//Task1.3
	public static void insertionSort(int[] array) {
		int n = array.length;
		for (int i = 1; i < n; i++) {
			int key = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] < key) {
				array[j] = array[j + 1];
				j--;
			}
			array[j + 1] = key;
		}
	}
//Task2.1
	public static void mergeSort(int[] array) {
		if (array.length > 1) {
			int mid = array.length / 2;
			int[] left = Arrays.copyOfRange(array, 0, mid);
			int[] right = Arrays.copyOfRange(array, mid, array.length);
			mergeSort(left);
			mergeSort(right);
			int i = 0, j = 0, k = 0;
			while (i < left.length && j < right.length) {
				if (left[i] >= right[j]) {
					array[k++] = left[i++];
				} else {
					array[k++] = right[j++];
				}
			}
			while (i < left.length) {
				array[k++] = left[i++];
			}
			while (j < right.length) {
				array[k++] = right[j++];
			}
		}
	}
	//Task2.2
	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int pivot = getPivot_MedianOfThree(array, low, high);
			int pi = partition(array, low, high, pivot);
			quickSort(array, low, pi - 1);
			quickSort(array, pi + 1, high);
		}
	}
	private static int getPivot_MedianOfThree(int[] array, int low, int high) {
		int mid = low + (high - low) / 2;
		int a = array[low];
		int b = array[mid];
		int c = array[high];

		if ((a < b && b < c) || (c < b && b < a))
			return mid;
		else if ((b < a && a < c) || (c < a && a < b))
			return low;
		else
			return high;
	}

	private static int partition(int[] array, int low, int high, int pivot) {
		int pivotValue = array[pivot];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (array[j] < pivotValue) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}

		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;

		return i + 1;
	}

	public static void main(String[] args) {
		int[] array = { 1, 5, 8, 3, 7, 9, 2 ,5};
		selectionSort(array);
		inMang(array);
		bubbleSort(array);
		inMang(array);
		insertionSort(array);
		inMang(array);
		mergeSort(array);
		inMang(array);
	
		System.out.println(	getPivot_MedianOfThree(array, 3 , 6));
		
	}
}