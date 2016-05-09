package test.string;

/*
 * Remove “b” and “ac” from a given string<br>
 * Given a string, eliminate all “b” and “ac” in the string, you have to replace
 * them in-place, and you are only allowed to iterate over the string once.
 * (Source Google Interview Question)
 * 
 * Examples:
 * 
 * acbac ==> ""
 * aaac ==> aa
 * ababac ==> aa
 * bbbbd ==> d
 * 
 * http://www.geeksforgeeks.org/remove-a-and-bc-from-a-given-string/
 * 
 * @author hix-test
 *
 */
public class RemoveBandAC {
	public static void main(String[] args) {
		String inputs[] = { "acbac", "aaac", "ababac", "bbbbd" };
		for (String s : inputs) {
			System.out.println("input: " + s + ", output:"
					+ removeBandAC(s.toCharArray()));
		}
	}

	static String removeBandAC(char[] s) {
		int result = 0;
		int scanner = 0; // input is the current index being scanned
		while (scanner < s.length) {
			if (scanner < s.length - 1 && s[scanner] == 'a'
					&& s[scanner + 1] == 'c') {
				scanner = scanner + 2;
			} else if (s[scanner] == 'b') {
				scanner++;
			} else {
				// copy the character to result and move forward
				if (scanner != result) {
					s[result] = s[scanner];
				}
				result++;
				scanner++;
			}
		}
		while (result < s.length) {
			s[result++] = ' ';
		}
		return new String(s);
	}
}
