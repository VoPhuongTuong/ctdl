package lab2;

public class Task1_1 {
	public static int getSn1(int n) {
		int a = 0;
		if (n == 1) {
			return 1;
		} else {
			a = (int) Math.pow((-1), n + 1) * n;
			getSn1(n - 1);
		}

		return a + getSn1(n - 1);
	}

	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	public static int getSn2(int n) {
		if (n == 1) {
			return 1;

		} else {
			return getSn2(n - 1) + factorial(n);
		}
	}

	public static int getSn3(int n) {
		if (n == 1) {
			return 1;
		} else {
			return (int) (getSn3(n - 1) + Math.pow(n, 2));
		}

	}
	public static int factorial1(int i) {

		if (i == 0) {
			return 1;
		} else {

			return i * factorial1(i - 2);
		}
	}

	public static double getSn4(int n) {
		if (n == 0) {
			return 1;
		} else {
			return getSn4(n - 1) + 1 / (double) (factorial1(2 * n));
		}

	}
	
	public static void main(String[] args) {
		int n = 3;
		System.out.println(getSn1(n));
		System.out.println(getSn2(n));
		System.out.println(getSn3(n));
		System.out.println(getSn4(n));	
	}
}
