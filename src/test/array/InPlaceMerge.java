package test.array;

public class InPlaceMerge {
	public static void main(String[] args) {
		int ar1[] = { 1, 5, 9, 10, 15, 20 };
		int ar2[] = { 2, 3, 8, 13 };
		System.out.println("Original");
		ArrayUtils.printArr(ar1);
		ArrayUtils.printArr(ar2);
		merge(ar1, ar2);
		
	}

	static void merge(int[] ar1, int[] ar2) {
		int m = ar1.length;
		int n = ar2.length;
		for (int i = n - 1; i >= 0; i--) {
			int j, last = ar1[m - 1];
			for (j = m - 2; j >= 0 && ar1[j] > ar2[i]; j--)
				ar1[j + 1] = ar1[j];
			if (j != m - 1) {
				ar1[j + 1] = ar2[i];
				ar2[i] = last;
			}
			System.out.println("Iteration:" + (n - i));
			ArrayUtils.printArr(ar1);
			ArrayUtils.printArr(ar2);
		}
	}
}
