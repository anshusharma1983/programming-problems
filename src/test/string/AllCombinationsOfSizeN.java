package test.string;

/**
 * Given a String print all combinations of characters with size n
 * printPermutations is the best method here. Similar theme of
 * AllPermutationsOfString !!
 * 
 * @author Anshu
 * 
 */
public class AllCombinationsOfSizeN {

	public static void main(String[] args) {
		String word = "123456";
		boolean flags[] = new boolean[word.length()];
		// printWithoutRecursion(word, 3);
		// printWithRecursion(word, 3);
		printCombinations(word, "", 3);
		System.out.println();
//		printPermutations(word, "", 3, flags);

	}

	public static void printCombinations(String initial, String combined, int k) {
		if (combined.length() >= k) {
			System.out.print(combined + " ");
			return;
		}
		for (int i = 0; i < initial.length(); i++) {
			printCombinations(initial.substring(i + 1),
					combined + initial.charAt(i), k);
			// printCombinations(initial, combined + initial.charAt(i), k);
		}
	}

	/**
	 * not working properly
	 * 
	 * @param word
	 * @param k
	 */
	public static void printWithoutRecursion(String word, int k) {
		for (int from = 0; from < word.length(); from++) {
			for (int to = from + 1; to <= word.length(); to++) {
				if ((to - from) == k) {
					System.out.println(word.substring(from, to));
				}
			}
		}
	}

	// not working correctly
	public static void printWithRecursion(String word, int k) {
		if (word.length() == 0) {
			return;
		}
		if (word.length() == 2)
			System.out.println(word);
		printWithRecursion(word.substring(1, word.length()), k);
		printWithRecursion(word.substring(0, word.length() - 1), k);
	}

	/*
	 * Working fine. Similar theme of allpermutations and sortedPermutations.
	 * Print permutations ordered of length k
	 */
	static void printPermutations(String s, String stringToPrint, int k,
			boolean[] flags) {
		if (stringToPrint.length() == k) {
			System.out.println(stringToPrint);
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			if (flags[i])
				continue;
			flags[i] = true;
			if (stringToPrint.length() == 0
					|| s.charAt(i) > stringToPrint.charAt(stringToPrint
							.length() - 1)) {
				printPermutations(s, stringToPrint + s.charAt(i), k, flags);
			}
			flags[i] = false;
		}
	}
}
