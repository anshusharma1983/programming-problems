package test.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find all possible palindromic partitions of given string.<br>
 * Input: n i t i n Output: n iti n nitin
 * 
 * @author hix-test
 *
 */

// Incorrect solution, check - UniqueSubstrings
public class PalindromePartitions {
	public static void main(String[] args) {
		String str = "nitin";
		Set<String> set = new HashSet<String>();
		allPossibleSubstrings(set, str, 0, str.length());
		for (String s : set) {
			System.out.println(s);
		}
		// System.out.println(isPalindrome("nitin"));
	}

	static boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	static void allPossibleSubstrings(Set<String> set, String s, int l, int r) {
		for (int i = l; i < r; i++) {
			if (i - l + 1 > l) {
				if (isPalindrome(s.substring(l, i - l + 1))) {
					set.add(s.substring(l, i - l + 1));
				}
			}
			allPossibleSubstrings(set, s, i + 1, r);
		}
	}
}
