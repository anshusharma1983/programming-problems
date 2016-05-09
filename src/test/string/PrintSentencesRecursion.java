package test.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: {{"you", "we"},<br>
 * {"have", "are"},<br>
 * {"sleep", "eat", "drink"}}<br>
 * 
 * Output: you have sleep <br>
 * you have eat <br>
 * you have drink <br>
 * you are sleep <br>
 * you are eat <br>
 * you are drink <br>
 * we have sleep <br>
 * we have eat <br>
 * we have drink <br>
 * we are sleep <br>
 * we are eat <br>
 * we are drink <br>
 * 
 * 
 * The idea is based on simple depth first traversal. We start from every word
 * of first list as first word of an output sentence, then recur for the
 * remaining lists.
 * 
 * @author hix-test
 *
 */
public class PrintSentencesRecursion {
	public static void main(String[] args) {
		String arr[][] = { { "you", "we" }, { "have", "are" },
				{ "sleep", "eat", "drink" } };
		printSentences(arr, 0, new ArrayList<String>());
	}

	static void printSentences(String[][] list, int depth, List<String> prefix) {
		if (depth == list.length) {
			return;
		}
		String[] words = list[depth];
		for (int i = 0; i < words.length; i++) {
			if (depth == list.length - 1) {
				for (String word : prefix) {
					System.out.print(" " + word);
				}
				System.out.print(" " + words[i]);
				System.out.println();
			} else {
				prefix.add(words[i]);
			}
			printSentences(list, depth + 1, prefix);
			prefix.remove(words[i]);
		}
	}
}
