package test.dynamic;

import test.array.ArrayUtils;

/**
 * Longest common subsequence
 * 
 * @author Anshu
 * 
 */
public class LCS {
	// correct
	private static int LCSrecurse(char[] a, char[] b, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		} else if (a[m - 1] == b[n - 1]) {
			return 1 + LCSrecurse(a, b, m - 1, n - 1);
		} else {
			return ArrayUtils.max(LCSrecurse(a, b, m - 1, n),
					LCSrecurse(a, b, m, n - 1));
		}
	}

	// incorrect
	private static int LCSDynamic(char[] a, char[] b, int m, int n) {
		Integer[][] L = new Integer[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					if (a[i] != b[i]) {
						L[i][j] = 0;
					} else {
						L[i][j] = 1;
					}
				} else if (a[i] == b[j]) {
					L[i][j] = L[i - 1][j - 1] + 1;
				} else {
					L[i][j] = ArrayUtils.max(L[i - 1][j], L[i][j - 1]);
				}
			}
		}
		return L[m - 1][n - 1];
	}

	public static void main(String[] args) {

		char a[] = "AGGTAB".toCharArray();
		char b[] = "GXTXAYB".toCharArray();
		System.out.println("Recurse: " + LCSrecurse(a, b, a.length, b.length));
		System.out.println("Dynamic: " + LCSDynamic(a, b, a.length, b.length));
		System.out.println("new:" + LCS1(a, b, a.length - 1, b.length - 1));
	}

	private static int LCS1(char[] a, char[] b, int m, int n) {
		// breaking condition
		if (m < 0 || n < 0) {
			return 0;
		}
		if (a[m] == b[n]) {
			return 1 + LCS1(a, b, m - 1, n - 1);
		} else {
			return ArrayUtils.max(LCS1(a, b, m, n - 1), LCS1(a, b, m - 1, n));
		}

	}

}
