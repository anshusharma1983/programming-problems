package test.dynamic;

import test.array.ArrayUtils;

/**
 * Longest common subsequence
 * 
 * @author Anshu
 * 
 */
public class LCS {

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

	private static int LCSDynamic(char[] a, char[] b, int m, int n) {
		Integer[][] L = new Integer[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					L[i][j] = 0;
				} else if (a[i] == b[j]) {
					L[i][j] = L[i - 1][j - 1] + 1;
				} else {
					L[i][j] = ArrayUtils.max(L[i - 1][j], L[i][j - 1]);
				}
			}
		}
		return L[m-1][n-1];
	}

	public static void main(String[] args) {

		char a[] = "abc".toCharArray();
		char b[] = "abcd".toCharArray();
		System.out.println("Recurse: "
				+ LCSrecurse(a, b, a.length, b.length));
		System.out.println("Dynamic: "
				+ LCSDynamic(a, b, a.length, b.length));
	}

}
