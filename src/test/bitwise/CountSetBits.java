package test.bitwise;

/*
 * Write an efficient program to count number of 1s in binary representation of an integer.
 http://www.geeksforgeeks.org/count-set-bits-in-an-integer/
 */
public class CountSetBits {
	public static void main(String[] args) {
		System.out.println(countSetBitsSimple(7));
	}

	/*
	 * Brian Kernighan’s
	 */
	static int countSetBits(int n) {
		int count = 0;
		while (n != 0) {
			// System.out.println(n);
			n = n & (n - 1);
			count++;
		}
		return count;
	}

	/*
	 * simple counting by right shifting
	 */
	static int countSetBitsSimple(int n) {
		int count = 0;
		while (n > 0) {
			count += 1 & n;
			n = n >> 1;
		}

		return count;
	}
}
