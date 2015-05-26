package test.string;

/**
 * Given a String print all combinations of characters with size n
 * 
 * @author Anshu
 * 
 */
public class AllCombinationsOfSizeN {

	public static void main(String[] args) {
		String word = "1234";
		int k = 2;
		// printWithoutRecursion(word, 2);
		// printWithRecursion(word, 2);
		// printCombinations(word, "", k);
	}

	public static void printCombinations(String initial, String combined, int k) {
		if (combined.length() == k) {
			System.out.print(combined + " ");
		}
		for (int i = 0; i < initial.length(); i++) {
			printCombinations(initial.substring(i + 1),
					combined + initial.charAt(i), k);

		}
	}

	public static void printWithoutRecursion(String word, int k) {
		for (int from = 0; from < word.length(); from++) {
			for (int to = from + 1; to <= word.length(); to++) {
				if ((to - from) == k) {
					System.out.println(word.substring(from, to));
				}
			}
		}
	}

	public static void printWithRecursion(String word, int k) {
		if (word.length() == 0) {
			return;
		}
		if (word.length() == 2)
			System.out.println(word);
		printWithRecursion(word.substring(1, word.length()), k);
		printWithRecursion(word.substring(0, word.length() - 1), k);
	}
}
