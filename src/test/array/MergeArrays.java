package test.array;

/**
 * 
 * @author Anshu
 * 
 */
public class MergeArrays {

	public static void main(String[] args) {
		int a[] = { 3, 5, 6, 9, 12, 14, 18, 20, 25, 28 };
		int b[] = {30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		mergeArray(a, b, 10);
		printArr(b);
	}

	static void mergeArray(int[] a, int[] b, int M) {
		// copy the b array to last M
		for (int i = M; i < 2 * M; i++) {
			b[i] = b[i - M];
		}
		int a1 = 0;
		int b1 = M;
		int index = 0;
		while (true) {
			if (index >= 2 * M) {
				// work done
				return;
			} else if (a1 >= M) {
				// fill all b1s
				while (index < 2 * M) {
					b[index++] = b[b1++];
				}
			} else if (b1 >= 2 * M) {
				// fill all a1s
				while (index < 2 * M) {
					b[index++] = a[a1++];
				}
			} else {
				if (a[a1] < b[b1]) {
					b[index++] = a[a1++];
				} else {
					b[index++] = b[b1++];
				}
			}
		}
	}

	static void printArr(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
