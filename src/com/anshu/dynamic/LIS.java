package test.dynamic;

/**
 * Longest increasing subsequence - working correctly
 * 
 * @author Anshu
 * 
 */
public class LIS {
	private static int getLIS(Integer[] a) {
		Integer[] L = new Integer[a.length];
		L[0] = 1;
		for (int j = 1; j < a.length; j++) {
			L[j] = 1;
			for (int i = j - 1; i >= 0; i--) {
				if (a[j] > a[i] && (L[i] + 1 > L[j])) {
					L[j] = L[i] + 1;
				}
			}
		}
		return getMax(L);
	}

	private static int getMax(Integer[] l) {
		int max = -1;
		for (int i = 0; i < l.length; i++) {
			System.out.print(l[i] + " ");
			if (l[i] > max) {
				max = l[i];
			}
		}
		System.out.println();
		return max;
	}

	public static void main(String[] args) {
		Integer[] a = { 1, 2, 0, 4, 5, 6, 3, -1 };
		System.out.println(getLIS(a));
	}
}
