package test.string;

/**
 * Given a string, remove all spaces from the string and return it. <br>
 * Input: "g  eeks   for ge  eeks  " <br>
 * Output: "geeksforgeeks"
 * 
 * @author hix-test
 *
 */
public class RemoveSpaces {
	public static void main(String[] args) {
		System.out.println(removeSpaces("g  eeks   for ge  eeks  ".toCharArray()));
	}

	public static char[] removeSpaces(char[] s) {
		int inputIdx = 0, outputIdx = 0;
		for (inputIdx = 0; inputIdx < s.length; inputIdx++) {
			if (s[inputIdx] != ' ') {
				s[outputIdx] = s[inputIdx];
				outputIdx++;
			}
		}
		while (outputIdx < s.length) {
			s[outputIdx] = ' ';
			outputIdx ++;
		}
		return s;
	}

}
