package test.string;

public class StringWithSpace {
	public static void printStrings(String s, int i, String temp) {
		temp = temp + s.charAt(i);
		if (i == s.length() - 1) {
			System.out.println(temp);
			return;
		}
		printStrings(s, i + 1, temp);
		temp = temp + " ";
		printStrings(s, i + 1, temp);
	}

	public static void main(String[] args) {
		// printStrings("ABC", 0, " ");
		printStrings2("ABC");
	}

	/**
	 * Suppose there are n characters, then there are n-1 positions where a
	 * space can be inserted. Each position can either take a 0 (no space) or 1.
	 * So if we just iterate from 0 to n-1 in binary form, we cover all such use
	 * cases.
	 * 
	 * @param s
	 */
	static void printStrings(String s) {
		int exp = (int) Math.pow(2, s.length());
		for (int i = 0; i < (exp / 2); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (j == 0) {
					System.out.print(s.charAt(j));
					continue;
				}

				int check = (1 << (j - 1)) & i;
				if (check >= 1) {
					System.out.print(" " + s.charAt(j));
				} else {
					System.out.print(s.charAt(j));
				}
			}
			System.out.print("\n");
		}
	}

	/**
	 * Suppose there are n characters, then there are n-1 positions where a
	 * space can be inserted. Each position can either take a 0 (no space) or 1.
	 * So if we just iterate from 0 to n-1 in binary form, we cover all such use
	 * cases.
	 *
	 * Eg. for ABC, we have 00,01,10,11 correspond to ABC, AB C, A BC, A B C
	 * 
	 * @param s
	 */
	static void printStrings2(String s) {
		int exp = (int) Math.pow(2, s.length());
		for (int i = 0; i < exp / 2; i++) {
			for (int j = 0; j < s.length(); j++) {
				if (j == 0) {
					System.out.print(s.charAt(j));
					continue;
				}
				if (((1 << (j - 1)) & i) >= 1) {
					System.out.print(" " + s.charAt(j));
				} else {
					System.out.print(s.charAt(j));
				}
			}
			System.out.println();
		}
	}
}
