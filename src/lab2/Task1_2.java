package lab2;

public class Task1_2 {
	public static int getFibonacci(int n) {
		if (n <= 1) {
			return n;
		} else {
			return (getFibonacci(n - 1) + getFibonacci(n - 2));
		}
	}

	public static void printFibonacci(int n) {
		if (n <= 0) {
			System.out.println("Invalid input");
			return;
		}
		for (int i = 0; i < n; i++) {
			System.out.print(getFibonacci(i) + " ");
		}
	}
	public static void main(String[] args) {

		int n = 6;
		System.out.println(getFibonacci(n));
		int n1= 6;
		printFibonacci(n1);
		
	}
}
