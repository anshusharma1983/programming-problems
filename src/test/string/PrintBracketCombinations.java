package test.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Print valid bracket combinations for count n
 * 
 * @author hix-test
 *
 */
public class PrintBracketCombinations {
	static Set<String> brackets = new HashSet<String>();

	public static void main(String[] args) {
		printBrackets(3, "", "");
		for (String s : brackets) {
			System.out.println(s);
		}
	}

	public static void printBrackets(int count, String prefix, String suffix) {
		if (count == 0) {
			brackets.add(prefix + "()" + suffix);
			return;
		}
		printBrackets(count - 1, prefix + "(", suffix + ")");
		printBrackets(count - 1, prefix + "()", suffix + "");
		printBrackets(count - 1, prefix + "", suffix + "()");
	}
}
