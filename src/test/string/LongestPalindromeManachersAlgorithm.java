package test.string;

/**
 * C, R<br>
 * T = $ # A # B # A # B # A # B # A # @<br>
 * P = 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 <br>
 * i = 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 // 10-16<br>
 * 
 * @author hix-test A B A B A B A<br>
 */
public class LongestPalindromeManachersAlgorithm {
	public static void main(String[] args) {

	}

	static int[] manacherAlgorithm(char[] T) {
		int[] P = new int[T.length];
		int C = 0, R = 0;
		for (int i = 0; i < T.length - 1; i++) {
			int mirror = 2 * C - i;
			if (i < R) {
				P[i] = Math.min(R - i, P[mirror]);
			}
			while (T[i + (1 + P[i])] == T[i - (1 + P[i])]) {
				P[i]++;
			}
			if (i + P[i] > R) {
				C = i;
				R = i + P[i];
			}
		}

		return P;
	}
}
