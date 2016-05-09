package test.string;

/**
 * Remove duplicate characters from string.
 * http://www.geeksforgeeks.org/remove-all-duplicates-from-the-input-string/
 * @author hix-test
 *
 */

/*
 * Algorithm
 * string = "test string"
 * 
 * either binary hash of 128 characters, or a byte to store flags (use bit manipulation)
 * 
 * Use two pointers to keep track of current character in input and output string - int in_index; out_index;
 * 
 * if (character is already present in the bit hash) {
 * do not copy the character, increment the input index
 * in_index++; 
 * }else {
 * character was not present, copy the character to output string (in place) and move both indexes 
 * str[out_index] = str[inp_index];
 * out_index++, in_index++;
 * }
 * @author hix-test
 *
 */
public class RemoveDuplicatesFromString {
	public static void main(String[] args) {
		System.out.println(removeDuplicates("the best string".toCharArray()));
	}
	
	private static char[] removeDuplicates(char[] s){
		int hash = 0;
		int inIndex = 0, outIndex = 0;
		for (inIndex = 0; inIndex < s.length; inIndex++) {
			int val = s[inIndex] - 'a';
			
			System.out.println("val:" + val + " hash:" + hash + ", hash&val:" + (hash & val));
			if ((hash & (1 << val)) == 0){
				// the character was not visited before
				System.out.println(s[inIndex] + " not visited before");
				s[outIndex] = s[inIndex];
				outIndex++;
				hash = (hash | ( 1 << val));
			}else {
				System.out.println(s[inIndex] + " is visited before");
				// the character has been visited before
			}
		}
		System.out.println("outIndex:" + outIndex + ", s.length:" + s.length);
		for (int i= outIndex; i < s.length; i++) {
				s[i] = ' ';
		}
		return s;
	}
}
