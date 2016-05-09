package test.string;

/**
 * http://www.geeksforgeeks.org/recursively-remove-adjacent-duplicates-given-
 * string/<br>
 * Given a string, recursively remove adjacent duplicate characters from string.
 * The output string should not have any adjacent duplicates. See following
 * examples.<br>
 * 
 * Input: azxxzy<br>
 * Output: ay<br>
 * First "azxxzy" is reduced to "azzy". The string "azzy" contains duplicates,
 * so it is further reduced to "ay".
 * 
 * Input: geeksforgeeg<br>
 * Output: gksfor<br>
 * First "geeksforgeeg" is reduced to "gksforgg". The string "gksforgg" contains
 * duplicates, so it is further reduced to "gksfor".
 * 
 * Input: caaabbbaacdddd<br>
 * Output: Empty String
 * 
 * Input: acaaabbbacdddd<br>
 * Output: acac
 * 
 * 
 * @author hix-test
 *
 */
public class RecurseRemoveDuplicates {
	public static void main(String[] args) {
		found = false;
		removeDuplicates("azxxzy");
		found = false;
		removeDuplicates("geeksforgeeg");
		found = false;
		removeDuplicates("caaabbbaacdddd");
		found = false;
		removeDuplicates("acaaabbbacdddd");
	}

	static boolean found = false;

	static void removeDuplicates(String str) {
		// System.out.println("processing :" + str);
		if (str.isEmpty() && found == false) {
			System.out.println("Empty string");
			found = true;
		}
		for (int i = 0; i < str.length(); i++) {
			if (i + 1 == str.length()) {
				// reached last char, so surely no duplicates now
				if (found == false) {
					System.out.println(str);
					found = true;
				}
				return;
			} else if (str.charAt(i + 1) == str.charAt(i)) {
				int j = i + 1;
				while (j < str.length()) {
					if (str.charAt(j) != str.charAt(i)) {
						break;
					}
					j++;
				}
				String prefix = "";
				String suffix = "";
				if (i > 0) {
					prefix = str.substring(0, i);
				}
				if (j < str.length()) {
					suffix = str.substring(j, str.length());
				}
				removeDuplicates(prefix + suffix);
			}
		}
	}
}
