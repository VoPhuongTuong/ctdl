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
		public String encrypt(String input) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < input.length(); i++) {
				char x = input.charAt(i);
				char y= encryptChar(x);
				builder.append(y);
			}
			return builder.toString();		
	}
		
		public char decryptChar(char c) {
			int x = -2;
			for (int i = 0; i < ALPHABET.length; i++) {
				if (ALPHABET[i] == c) {
					x = i;
					break;
				}
			}
			if (x!= -2) {
				int y = (x -n) % 26;
			if(y<0)

					y = y + 26;
				return ALPHABET[y];
			} else {
				return c;
			}
		}
		public String decrypt(String input) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < input.length(); i++) {
				char x = input.charAt(i);
				char y = decryptChar(x);
				builder.append(y);
			}
			return builder.toString();
		}
	public static void main(String[] args) {
		MyCaesar task2 = new MyCaesar(4);
	String x1 = task2.decrypt("HOALA");
		System.out.println(x1);
	}

}