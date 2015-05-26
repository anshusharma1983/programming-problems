package test.string;

import java.util.Set;

/**
 * Given a set S and k, print all strings of length k that can be formed using
 * the set S
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
		char a[] = "abcde".toCharArray();
		int k = 3;
		printStrings(a, "", k);
	}
}
