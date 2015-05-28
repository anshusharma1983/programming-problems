package test.dynamic;

import java.util.Set;

/**
 * Consider the following dictionary { i, like, sam, sung, samsung, mobile, ice,
 * cream, icecream, man, go, mango}
 * 
 * Input: ilike Output: Yes The string can be segmented as "i like".
 * 
 * Input: ilikesamsung Output: Yes The<br>
 * string can be segmented as "i like samsung" or "i like sam sung".
 * 
 * @author Anshu
 * 
 */
public class WordBreak {
	public static Boolean wordBreak(String[] set, String subStr, String str) {
		if (str.length() == 0) {
			return true;
		}

		if (setContainsString(set, subStr)) {
			str.replace(subStr, "");
		}

		String prefix = "";
		for (int i = 0; i < str.length(); i++) {
			prefix += str.substring(0, i);
			return wordBreak(set, prefix, str);
		}
		return false;
	}

	private static boolean setContainsString(String[] set, String subStr) {
		for (int i = 0; i < set.length; i++) {
			if (set[i].equals(subStr)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String[] set = { "mobile", "samsung", "sam", "sung", "man", "mango",
				"icecream", "and", "go", "i", "like", "ice", "cream" };
		if (wordBreak(set, "", "ilikesamsung")) {
			System.out.println("yes");
		}
	}
}
