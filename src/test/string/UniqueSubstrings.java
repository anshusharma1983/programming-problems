package test.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Print all unique substrings in a given string
 * 
 * @author hix-test
 *
 */
public class UniqueSubstrings {
	public static void main(String[] args) {
		System.out.println(uniqueSubstrings("nitin"));
		System.out.println(palindromicSubstrings("nitin"));
	}

	// second loop in upper bound
	static Set<String> uniqueSubstrings(String str) {
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < str.length(); i++)
			for (int j = i; j < str.length(); j++)
				set.add(str.substring(i, j + 1));
		return set;
	}

	// second loop in lower bound, both works !
	static Set<String> uniqueSubstrings2(String str) {
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < str.length(); i++)
			for (int j = 0; j <= i; j++)
				set.add(str.substring(j, i + 1));
		return set;
	}

	static Set<String> palindromicSubstrings(String str) {
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < str.length(); i++)
			for (int j = i; j < str.length(); j++)
				if (isPalindrome(str.substring(i, j + 1))) {
					set.add(str.substring(i, j + 1));
				}
		return set;
	}

	static boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

}
