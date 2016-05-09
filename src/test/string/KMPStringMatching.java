package test.string;

/**
 * https://www.youtube.com/watch?v=t4xUA-aHzy8<br>
 * Knuth–Morris–Pratt (KMP) Pattern Matching<br>
 * 
 * First calculate the LPS table (longest prefix that is also suffix), after
 * that apply KMP algo
 * 
 * LPS<br>
 * STR : a b c d a b c<br>
 * LPS : 0 0 0 0 1 2 3
 * 
 * @author hix-test
 *
 */
public class KMPStringMatching {
	public static void main(String[] args) {
		String str = "abcabcdab";
		System.out.println(str);
		System.out.println(printArr(calculateLPS(str)));
	}

	static int[] calculateLPS(String s) {
		int[] LPS = new int[s.length()];
		int j = 0, i = 1;
		LPS[j] = 0;
		while (i < s.length()) {
			if (s.charAt(i) == s.charAt(j)) {
				LPS[i] = j + 1;
				i++;
				j++;
			} else {
				if (j == 0) {
					LPS[i] = 0;
					i++;
				} else {
					// how?? because we need to find a j with which we can match
					// i
					j = LPS[j - 1];
				}
			}
		}
		return LPS;
	}
	
	

	static String printArr(int[] arr) {
		String str = "";
		for (int i = 0; i < arr.length; i++) {
			str = str + arr[i];
		}
		return str;
	}
}
