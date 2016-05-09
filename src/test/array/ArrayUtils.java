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

	public static void printArr(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void swap(int A[], int i, int j) {
		int t = A[i];
		A[i] = A[j];
		A[j] = t;
	}

}
