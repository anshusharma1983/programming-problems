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

	/**
	 * incorrect as it only takes into account the continuous numbers<br>
	 * Need to be changed to -<br>
	 * L(i) = { 1 + Max ( L(j) ) } where j < i and arr[j] < arr[i] and if there
	 * is no such j then L(i) = 1
	 */
	private static void LISRecurse(Integer[] arr, Integer[] count, int index) {
		if (index == arr.length - 1) {
			for (int i = 0; i < count.length; i++) {
				System.out.print(" " + count[i]);
			}
			return;
		}
		if (index > 0) {
			if (arr[index] > arr[index - 1]) {
				count[index] = count[index - 1] + 1;
			} else {
				count[index] = 1;
			}
		} else if (index == 0) {
			// index = 0
			count[index] = 1;
		}
		LISRecurse(arr, count, index + 1);
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
		// System.out.println(getLIS(a));
		Integer[] count = new Integer[a.length];
		for (int i = 0; i < count.length; i++) {
			count[i] = 0;
		}
		LISRecurse(a, count, 0);
	}
}
