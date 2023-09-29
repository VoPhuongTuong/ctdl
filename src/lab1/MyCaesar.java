package lab1;

public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	public char encryptChar(char c) {
		int x = -2;
		for (int i = 0; i < ALPHABET.length; i++) {
			if (ALPHABET[i] == c) {
				x = i;
				break;
			}
		}
		if (x != -2) {
			int y = (x + n) % 26;
			return ALPHABET[y];
		} else {
			return c;
		}

	}

	public static void main(String[] args) {
		MyCaesar task2 = new MyCaesar(3);
		char x1 = task2.encryptChar('D');
		System.out.println(x1);
	}

}