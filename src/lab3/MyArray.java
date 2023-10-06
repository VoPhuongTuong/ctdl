package lab3;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;

	}

	public int iterativeLinearSearch(int target) {
		int n = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				n = i;
				break;
			} else {
				n = -1;
			}
		}
		return n;
	}

	public int recursiveLinearSeachHelp(int target, int index) {
		if (index == array.length) {
			return -1;
		} else {
			if (array[index] == target) {
				return index;
			} else {
				return recursiveLinearSeachHelp(target, index + 1);
			}
		}
	}

	public int recursiveLinearSeach(int target) {
		
		return recursiveLinearSeachHelp(target, 0);
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 4, 5, 7, 9 };
		MyArray ite = new MyArray(array);
		System.out.println(ite.iterativeLinearSearch(3));
		System.out.println(ite.recursiveLinearSeach(4));
	}
}
