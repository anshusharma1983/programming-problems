package test.youtube.binarysearch;

/**
 * trick: check which half is sorted, if element is there, search else search
 * other half
 * 
 * @author Anshu
 * 
 */
public class SearchNumberInCircularArray {
	public static void main(String[] args) {
		int arr[] = { 9, 10, 12, 1, 2, 3, 4, 6, 7 };
		int x = 7;
		System.out.println("Index of " + x + ":"
				+ binaryCircularSearch(arr, x, 0, arr.length - 1));
	}

	private static int binaryCircularSearch(int[] a, int x, int low, int high) {
		int mid = (low + high) / 2;
		System.out.println("low: " + low + ", high:" + high + ", arr[mid]:"
				+ a[mid]);

		if (high < low) {
			return -1;
		}
		if (a[mid] == x) {
			return mid;
		} else {
			if (a[low] < a[mid]) {
				// left half is sorted
				if (x > a[low] && x < a[mid]) {
					// search left
					System.out.println("search left");
					return binaryCircularSearch(a, x, low, mid - 1);
				} else {
					// search right
					System.out.println("search right");
					return binaryCircularSearch(a, x, mid + 1, high);
				}
			} else {
				// right half sorted
				if (x > a[mid] && x <= a[high]) {
					// search right
					System.out.println("search right");
					return binaryCircularSearch(a, x, mid + 1, high);
				} else {
					// search left
					System.out.println("search left");
					return binaryCircularSearch(a, x, low, mid - 1);
				}
			}
		}
	}
}
