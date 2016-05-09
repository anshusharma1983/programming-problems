package test.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string you need to print longest possible substring that has exactly
 * M unique characters. If there are more than one substring of longest possible
 * length, then print any one of them.
 * http://www.geeksforgeeks.org/find-the-longest
 * -substring-with-k-unique-characters-in-a-given-string/
 * 
 * "aabbcc", k = 1 Max substring can be any one from {"aa" , "bb" , "cc"}.
 * 
 * "aabbcc", k = 2 Max substring can be any one from {"aabb" , "bbcc"}.
 * 
 * "aabbcc", k = 3 There are substrings with exactly 3 unique characters
 * {"aabbcc" , "abbcc" , "aabbc" , "abbc" } Max is "aabbcc" with length 6.
 * 
 * "aaabbb", k = 3 There are only two unique characters, thus show error
 * message. <br>
 * 
 * My algo<br>
 * move left right pointers in window, keep a map of characters and last index
 * of that character found.
 * 
 * @author hix-test
 */
public class LongestSubstrWithKUniqChars {
	public static void main(String[] args) {
		// a b c a a a b b b b
		// 0 1 2 3 4 5 6 7 8 9
		longestSubstring("aabbcc".toCharArray(), 1);
		longestSubstring("aabbcc".toCharArray(), 2);
		longestSubstring("aaabbb".toCharArray(), 3);
		longestSubstring("abcaaabbbb".toCharArray(), 2);
		longestSubstring("abcaaabbbb".toCharArray(), 5);
		longestSubstring("anshusharmaismyname".toCharArray(), 4);
	}

	public static void longestSubstring(char[] str, int k) {
		int resultl = 0, resultr = 0;
		int l = 0, r = 0;
		Map<Character, Integer> characterIndexMap = new HashMap<Character, Integer>();
		characterIndexMap.put(str[0], 0);
		while (characterIndexMap.size() <= k && r < str.length - 1) {
			r++;
			if (characterIndexMap.containsKey(str[r])) {
				characterIndexMap.put(str[r], r);
			} else {
				// add the key and check if the size exceeded
				characterIndexMap.put(str[r], r);
				if (characterIndexMap.size() > k) {
					// update the result if needed
					if ((r - l - 1) > (resultr - resultl)) {
						// if newer string is better than previous result,
						// update it
						resultl = l;
						resultr = r - 1;
					}
				}
				while (characterIndexMap.size() > k) {
					if (l == characterIndexMap.get(str[l])) {
						characterIndexMap.remove(str[l]);
					}
					l++;
				}
			}
		}
		if (characterIndexMap.size() < k) {
			System.out.println("No enough unique characters!");
		} else {
			// System.out.println("l:" + resultl + ", r:" + resultr);
			for (int i = resultl; i <= resultr; i++) {
				System.out.print(str[i]);
			}
			System.out.println();
		}

	}
}
