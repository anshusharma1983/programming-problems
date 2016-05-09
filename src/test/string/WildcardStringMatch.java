package test.string;

/**
 * http://www.geeksforgeeks.org/wildcard-character-matching/<br>
 * String matching where one string contains wildcard characters Given two
 * strings where first string may contain wild card characters and second string
 * is a normal string. Write a function that returns true if the two strings
 * match. The following are allowed wild card characters in first string.
 * 
 * '*'--> Matches with 0 or more instances of any character or set of
 * characters.<br>
 * '?' --> Matches with any one character.<br>
 * 
 * For example, “g*ks” matches with “geeks” match. And string “ge?ks*” matches
 * with “geeksforgeeks” (note ‘*’ at the end of first string). But “g*k” doesn’t
 * match with “gee” as character ‘k’ is not present in second string.
 * 
 * @author hix-test
 *
 */
public class WildcardStringMatch {
	public static void main(String[] args) {
		String inputs[][] = { { "g*ks", "geeks" },
				{ "ge?ks", "geeksforgeeks" }, { "g*k", "gee" },
				{ "*pqrs", "pqrst" }, { "abc*bcd", "abcdhghgbcd" },
				{ "abc*c?d", "abcd" }, { "*c*d", "abcd" }, { "*?c*d", "abcd" } };
		// String inputs[][] = { { "?c", "ac" } };
		for (int i = 0; i < inputs.length; i++) {
			String wildcard = inputs[i][0];
			String str = inputs[i][1];
			System.out.println("input:" + wildcard + ", str:" + str
					+ ", result:" + wildcardMatch(wildcard, str, 0, 0));
		}
		// System.out.println(wildcardMatch("g*ks", "geeks", ));
	}

	private static boolean wildcardMatch(String wildcard, String str, int i,
			int j) {
		// System.out.println("i:" + i + ", j:" + j + ", w len:"
		// + wildcard.length() + ", s len:" + str.length());
		if (i >= wildcard.length() || j >= str.length()) {
			return false;
		}
		if (wildcard.charAt(i) == str.charAt(j) && i == wildcard.length() - 1
				&& j == str.length() - 1) {
			// we have come to last character of regex; its a match
			return true;
		} else if (wildcard.charAt(i) == '*') {
			// either increment j or not, because we can skip any characters on
			// *
			return wildcardMatch(wildcard, str, i, j + 1)
					|| wildcardMatch(wildcard, str, i + 1, j);
		} else if (wildcard.charAt(i) == str.charAt(j)
				|| wildcard.charAt(i) == '?') {
			return wildcardMatch(wildcard, str, i + 1, j + 1);
		}
		return false;
	}
}
