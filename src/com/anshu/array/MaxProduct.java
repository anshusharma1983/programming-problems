package test.array;

import java.util.HashMap;
import java.util.Map;

public class MaxProduct {

	static int max(int x, int y) {
		return x >= y ? x : y;
	}

	static int max(int x, int y, int z) {
		if (x >= y && x >= z) {
			return x;
		} else if (y >= x && y >= z) {
			return y;
		} else if (z >= x && z >= y) {
			return z;
		}
		return -1;
	}

	static Map<Integer, Integer> cache = new HashMap<Integer, Integer>();

	static int maxProd(int n) {
		if (n == 0)
			return 0;
		if (cache.containsKey(n)) {
			System.out.println("Yay.. hit cache for :" + n);
			return (Integer) cache.get(n);
		}
		System.out.println("Calculating max for :" + n);
		int value = n;
		for (int i = 1; i <= n; i++) {
			value = max(value, (n - i) * i, maxProd(n - i) * i);
			cache.put(n, value);
			System.out.println("max:" + value + ", for i:" + i + ", and n:" + n);
		}
		return value;
	}

	public static void main(String[] args) {
		System.out.println(maxProd(10));
	}
}
