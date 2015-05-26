package test.array;

public class ArrayUtils {
	public static int max(int x, int y) {
		return x >= y ? x : y;
	}

	public static int max(int x, int y, int z) {
		if (x >= y && x >= z) {
			return x;
		} else if (y >= x && y >= z) {
			return y;
		} else if (z >= x && z >= y) {
			return z;
		}
		return -1;
	}

}
