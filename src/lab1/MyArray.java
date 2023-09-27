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

	
	
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		MyArray newArr = new MyArray(arr);
		System.out.println(Arrays.toString(newArr.mirror()));
	}
}
