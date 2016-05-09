package test.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeleteString {

	public static void main(String[] args) {
		// Scanner in = new Scanner(System.in);
		// int res;
		// String _s;
		// _s = in.nextLine();
		// String _t;
		// _t = in.nextLine();
		// res = maxRounds(_s, _t);
		// System.out.println(res);
		String s = "ababab";
		String t = "ab";
		System.out.println(maxRounds(s, t));
	}

	private static int maxRounds(String s, String t) {

		if (s == null || t == null) {
			return 0;
		}

		String temp = "";
		int count = 0;
		/**
		 * if the length after first replacement is not same as the previous
		 * string then continue replacing and increase the count. If the length
		 * is same, that means nothing was replaced
		 */
		while (s.length() != (temp = s.replaceFirst(Pattern.quote(t), ""))
				.length()) {
			System.out.println(temp);
			s = temp;
			count++;
		}
		// }
		return count;
	}
}
