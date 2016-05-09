package test.string;

/**
 * http://www.geeksforgeeks.org/write-your-own-atoi/<br>
 * Convert a numeric string to number
 * 
 * @author hix-test
 *
 */
public class Atio {
	public static void main(String[] args) {
		System.out.println(atoi("579"));
	}

	static int atoi(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res = res * 10 + (s.charAt(i) - '0');
		}
		return res;
	}
}
