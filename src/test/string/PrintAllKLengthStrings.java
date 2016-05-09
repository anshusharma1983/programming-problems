package test.string;

/**
 * Given a set S and k, print all strings of length k that can be formed using
 * the set S<br>
 * Elegant solution. Please check AllPermutationsOfString and
 * SortedPermutationsString as well (similar approach) !!
 * 
 * @author Anshu
 * 
 */
public class PrintAllKLengthStrings {
	public static void printStrings(char[] s, String prefix, int k) {
		if (k == 0) {
			System.out.println(prefix);
			return;
		}
		for (int i = 0; i < s.length; i++) {
			String newprefix = prefix + s[i];
			printStrings(s, newprefix, k - 1);
		}
	}

	public static void main(String[] args) {
		char a[] = "abc".toCharArray();
		int k = 3;
		// printStrings(a, "", k);
		permute("abc", "", 3);
	}

	/*
	 * Elegant solution. Please check AllPermutationsOfString and
	 * SortedPermutationsString as well (similar approach) !!
	 */
	static void permute(String input, String output, int k) {
		if (output.length() == k) {
			System.out.println(output);
			return;
		}
		for (int i = 0; i < input.length(); i++) {
			permute(input, output + input.charAt(i), k);
		}
	}
}
