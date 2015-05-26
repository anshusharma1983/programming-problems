import java.util.Arrays;

/**
 * Given three arrays A,B,C containing unsorted numbers. Find three numbers a,
 * b, c from each of array A, B, C such that |a-b|, |b-c| and |c-a| are minimum
 * 
 * @author Anshu
 * 
 */
public class MinDiffArrays {
	static Integer[] arr1 = { 5, 2, 22, 0 };
	static Integer[] arr2 = { 9, 12, 4, 23 };
	static Integer[] arr3 = { 6, 3, 1, 15 };

	public static void main(String[] args) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		Arrays.sort(arr3);
		Integer[] finalElements = null;

		for (int i = 0; i < arr1.length; i++) {
			int a = arr1[i];
			int b = arr2[i];
			int c = arr3[i];
			int sum = Math.abs(a - b) + Math.abs(b - c) + Math.abs(c - a);
			if (finalElements == null) {
				finalElements = new Integer[3];
				finalElements[0] = a;
				finalElements[1] = b;
				finalElements[2] = c;
			} else {
				if ((finalElements[0] + finalElements[1] + finalElements[2]) > sum) {
					finalElements[0] = a;
					finalElements[1] = b;
					finalElements[2] = c;
				}
			}
		}
		System.out.println(finalElements[0] + "," + finalElements[1] + "," + finalElements[2]);
	}
}
