package test.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * max(j) = max { max(j-1) + A[j] , A[j] } -  working correctly
 * 
 * @author Anshu
 * 
 */
public class MaximumSubSequence {

	static int max(int x, int y) {
		System.out.println("max of " + x + "," + y);
		return x >= y ? x : y;
	}

	static int max(int x, int y, int z) {
		System.out.println("max of " + x + "," + y + "," + z);
		if (x >= y && x >= z) {
			return x;
		} else if (y >= x && y >= z) {
			return y;
		} else if (z >= x && z >= y) {
			return z;
		}
		return -1;
	}

	private static Map<Integer, Integer> cache = new HashMap();

	static Map<Integer, Integer> maxSumMap = new HashMap<Integer, Integer>();

	public static int maxDynamic2(int a[], int n) {
		if (maxSumMap.containsKey(n)) {
			return maxSumMap.get(n);
		}
		if (n == 0) {
			return a[0];
		}
		int sum = -1;
		for (int i = 1; i <= n; i++) {
			sum = max(maxDynamic2(a, i - 1) + a[i], a[i]);
			maxSumMap.put(i, sum);
		}
		return sum;

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, -10, 5, 3, -4, 2, 1 };
		System.out.println(maxDynamic2(arr, arr.length - 1));
		for (int key : maxSumMap.keySet()) {
			System.out.println("key:" + key + ", value:" + maxSumMap.get(key));
		}
	}
}
