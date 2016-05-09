package test.string;

public class ExcelColumnForNumbers {
	public static void main(String[] args) {
		int[] inputs = { 26, 51, 52, 80, 676, 702, 705 };
		for (int i = 0; i < inputs.length; i++) {
			System.out.println(inputs[i] + ":" + excel(inputs[i]));
			System.out.println(inputs[i] + ":" + printString(inputs[i]));
		}
		// System.out.println(702/26);
	}

	private static String excel(int n) {
		String result = "";
		while (n > 0) {
			if (n % 26 == 0) {
				result = result + 'Z';
				n = (n / 26) - 1;
			} else {
				result = result + (char) ('A' + (n % 26) - 1);
				n = n / 26;
			}
		}
		return new StringBuilder(result).reverse().toString();
	}

	// incorrect
	static String printString(int n) {
		return n == 0 ? "" : printString(n / 26) + (char) ((n - 1) % 26 + 'A');
	}
}
