package test.array;

/*
 * Dutch National flag algorithm
 * http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 * 
 * Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. The functions should put all 0s first, then all 1s and all 2s in last.

 Example
 Input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
 Output = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
 Algorithm:
 low = 0, mid = 0, high = arr.length -1;

 */
public class SortArrayOf3Digits {
	public static void sort(int[] arr) {
		int low = 0, mid = 0, high = arr.length - 1;
		while (mid <= high) {
			switch (arr[mid]) {
			case 0:
				// swap with low
				ArrayUtils.swap(arr, mid, low);
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				ArrayUtils.swap(arr, mid, high);
				high--;
				break;
			}
		}
	}

	static void simpleSort(int arr[]) {
		int size = arr.length;
		int c0 = 0;
		int c1 = 0;
		int c2 = 0;
		int i;
		for (i = 0; i < size; i++) {
			switch (arr[i]) {
			case 0:
				c0++;
				break;
			case 1:
				c1++;
				break;
			case 2:
				c2++;
				break;
			}
		}
		i = 0;

		while (c0-- > 0) {
			arr[i++] = 0;
		}
		while (c1-- > 0) {
			arr[i++] = 1;
		}
		while (c2-- > 0) {
			arr[i++] = 2;
		}
	}

	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		// sort(arr);
		simpleSort(arr);
		ArrayUtils.printArr(arr);

	}
}
