package test.string;

/*
 http://www.geeksforgeeks.org/print-all-permutations-with-repetition-of-characters/
 Print all permutations with repetition of characters
 Given a string of length n, print all permutation of the given string. Repetition of characters is allowed. Print these permutations in lexicographically sorted order 
 Examples:

 Input: AB
 Ouput: All permutations of AB with repetition are:
 AA
 AB
 BA
 BB

 Input: ABC
 Output: All permutations of ABC with repetition are:
 AAA
 AAB
 AAC
 ABA
 ...
 ...
 CCB
 CCC
 For an input string of size n, there will be n^n permutations with repetition allowed. The idea is to fix the first character at first index and recursively call for other subsequent indexes. Once all permutations starting with the first character are printed, fix the second character at first index. Continue these steps till last character. Thanks to PsychoCoder for providing following C implementation.
 */
public class SortedPermutationsString {
	public static void main(String[] args) {
		String s = "ABC";
//		boolean[] flags = new boolean[s.length()];
		printPermutations(s, "");
	}

	/*
	 * Please check AllPermutationsOfString as well, similar and elegant
	 * solution!
	 */
	static void printPermutations(String s, String stringToPrint) {
		if (stringToPrint.length() == s.length()) {
			System.out.println(stringToPrint);
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			printPermutations(s, stringToPrint + s.charAt(i));
		}
	}

	
}
