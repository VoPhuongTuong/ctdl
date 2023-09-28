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

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 4, 5, 4, 3, 2, 7 };
		MyArray newArr = new MyArray(arr);
		System.out.println(Arrays.toString(newArr.removeDuplicates()));
	}
}
