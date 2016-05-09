package test.string;

/**
 * IMPORTANT permute2 -- see SortedPermutationsString as well
 */
import java.util.Set;

/*
 * All permutations of string
 * Input: abc
 * Output:
 acb
 bac
 bca
 cab
 cba
 */
public class AllPermutationsOfString {

	public static void main(String[] args) {
		// Set<String> result = new HashSet<String>();
		// permute("abc", 0, result);
		// System.out.println(result.size() + ":" + result);
		String s = "abc";
		boolean[] flags = new boolean[s.length()];
//		permute2(s, "", flags);
		test(s, "", flags);
	}

	static void permute(String str, int d, Set<String> set) {
		if (d == str.length()) {
			set.add(str);
		}
		for (int i = d; i < str.length(); i++) {
			str = swap(str, i, d);
			permute(str, d + 1, set);
			// str = swap(str, i, d);
		}
	}

	static void test(String input, String output, boolean[] flags) {
		if (output.length() == input.length()) {
			System.out.println(output);
			return;
		}
		for (int i = 0; i < input.length(); i++) {
			if (flags[i] == true) {
				continue;
			}
			flags[i] = true;
			test(input, output + input.charAt(i), flags);
			flags[i] = false;
		}
	}

	/*
	 * Working and best solution !! Extremely similar to
	 * SortedPermutationsString, only difference is that we flag the current
	 * character to not be used in recursion, otherwise we would end up in
	 * having same character used multiple times
	 */
	static void permute2(String input, String output, boolean[] flags) {
		if (input.length() == output.length()) {
			System.out.println(output);
			return;
		}
		for (int i = 0; i < input.length(); i++) {
			if (flags[i])
				continue;
			flags[i] = true;
			permute2(input, output + input.charAt(i), flags);
			flags[i] = false;
		}
	}

	private static String swap(String str, int i, int d) {
		char tmp = str.charAt(i);
		StringBuilder sb = new StringBuilder(str);
		sb.setCharAt(i, str.charAt(d));
		sb.setCharAt(d, tmp);
		return sb.toString();
	}
}
