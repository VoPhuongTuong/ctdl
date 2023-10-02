package lab2;

import java.util.Arrays;

public class Task1_3 {
	public static void printPasscalTraingle(int row) {
		int[][] re = new int[row][];
		for (int i = 0; i < re.length; i++) {
			re[i] = new int[i + 1];
			re[i][0] = 1;
			re[i][i] = 1;
			for (int j = 1; j < i; j++) {
				re[i][j] = re[i - 1][j - 1] + re[i - 1][j];
			}
		}
		for (int i = 0; i < re.length; i++) {
			for (int j = 0; j < re[i].length; j++) {
				System.out.print(re[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[] generateNextRow(int[] prevRow) {
		int[] re = new int[prevRow.length + 1];
		re[0] = 1;
		re[re.length - 1] = 1;
		for (int i = 1; i < re.length - 1; i++) {
			re[i] = prevRow[i - 1] + prevRow[i];
		}
		return re;
	}

	public static int[] getPasscalTriangle(int n) {
		if (n == 1) {
			return new int[] { 1 };

		} else {
			int[] preRow = getPasscalTriangle(n - 1);
			return generateNextRow(preRow);

		}
	}

	public static void main(String[] args) {
		System.out.println();
		int[] input = { 1, 1, 1 };
		int[] re = generateNextRow(input);
		System.out.print(Arrays.toString(re));
		System.out.println();
		int[] result = getPasscalTriangle(5);
		System.out.println(Arrays.toString(result));
		printPasscalTraingle(5);
	}
}
