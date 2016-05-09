package test.string;

/**
 * http://www.geeksforgeeks.org/find-given-string-can-represented-substring-
 * iterating-substring-n-times/
 * 
 * Find if a given string can be represented from a substring by iterating the
 * substring “n” times
 * 
 * Given a string ‘str’, check if it can be constructed by taking a substring of
 * it and appending multiple copies of the substring together.
 * 
 * Examples:
 * 
 * Input: str = "abcabcabc" Output: true The given string is 3 times repetition
 * of "abc"
 * 
 * Input: str = "abadabad" Output: true The given string is 2 times repetition
 * of "abad"
 * 
 * Input: str = "aabaabaabaab" Output: true The given string is 4 times
 * repetition of "aab"
 * 
 * Input: str = "abcdabc" Output: false
 * 
 * @author hix-test
 *
 */
public class MultipleSubstrings {
	public static void main(String[] args) {
		// abcabcabcabc
		System.out.println(multipleSubstrings("aabaabaabaab"));
		System.out.println(multipleSubstrings("abcabcabc"));
		System.out.println(multipleSubstrings("abadabad"));
		System.out.println(multipleSubstrings("abcdabc"));
	}

	static int multipleSubstrings(String str) {
		String sub = str.charAt(0) + "";
		int idx = 0;
		int count = 0;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == sub.charAt(idx)) {
				idx++;
				if (idx == sub.length()) {
					count++;
					idx = 0;
				}
			} else {
				sub = str.substring(0, i + 1);
				idx = 0;
				count = 0;
			}
		}
		return count;
	}
}
