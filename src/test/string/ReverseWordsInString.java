package test.string;

/*
 Reverse words in a given string
 Example: Let the input string be “i like this program very much”. The function should change the string to “much very program this like i”
 */
public class ReverseWordsInString {
	public static void main(String[] args) {
		reverseWords("This is a test string".toCharArray());
	}

	static void reverseWords(char s[]) {
		String temp = "";
		for (int i = s.length - 1; i >= 0; i--) {
			if (s[i] == ' ') {
				System.out.print(temp + " ");
				temp = "";
			} else {
				temp = s[i] + temp;
			}
		}
		System.out.print(temp + " ");
	}
}
