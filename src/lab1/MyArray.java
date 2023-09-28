package lab1;

import java.util.Arrays;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	public int[] mirror() {
		int[] newArr = new int[array.length * 2];
		int j = array.length * 2 - 1;
		for (int i = 0; i < array.length; i++) {
			newArr[i] = array[i];
			newArr[j] = array[i];
			j--;
		}
		return newArr;
	}

	public int count() {
		int n = 0;
		for (int i = 0; i < array.length; i++) {
			boolean check = true;
			for (int j = 0; j < i; j++) {
				if (array[i] == array[j]) {
					check = false;
				}
			}
			if (check == true) {
				n++;
			}
		}
		return n;
	}

	public int[] removeDuplicates() {
		int[] newArray = new int[count()];
		int n = 0;
		for (int i = 0; i < array.length; i++) {
			boolean check = true;
			for (int j = 0; j < i; j++) {
				if (array[i] == array[j]) {
					check = false;
				}
			}
			if (check == true) {
				newArray[n] = array[i];
				n++;
			}
		}
		return newArray;
	}

	public int count1() {
		int n = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] + 1 != array[i + 1]) {
				n = n + (array[i + 1]) - (array[i]) - 1;
			}
		}
		return n;
	}

	public int[] getMissingValues() {
		int[] newArray = new int[count1()];
		int n = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] + 1 != array[i + 1]) {
				for (int j = 1; j < array[i + 1] - array[i]; j++) {
					newArray[n] = array[i] + j;
					n++;
				}
			}
		}
		return newArray;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 5, 7 };
		MyArray newArr = new MyArray(arr);
		System.out.println(Arrays.toString(newArr.getMissingValues()));
		System.out.println(newArr.count1());
	}
}
