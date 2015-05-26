package test.youtube.binarysearch;

public class NumberOfTimesArrayIsRotated {
	public static void main(String[] args) {
		int array[] = {  5, 4, 3, 2, 1 };
		// 7 1 2 3 4 5 6
		/**
		 * pivot property next and previous are both greater, index of the
		 * element would give how many times the array is sorted
		 */
		/**
		 * if low > high then keep searching, if low < high then the array is
		 * already sorted
		 */
		System.out.println("Sorted times:"
				+ timesSorted(array, 0, array.length - 1));
		System.out.println(" ====== ");
		System.out.println(" sorted: " + findRotation(array));
	}

	private static int timesSorted(int[] array, int low, int high) {
		int midIndex = (low + high) / 2;
		int midElement = array[midIndex];
		if (high <= low) {
			return low;
		}
		System.out.println("midElement:" + midElement);
		// make sure that midIndex is not < 0 and not > array.length - 1
		if (midElement < array[midIndex + 1]
				&& midElement < array[midIndex - 1]) {
			System.out.println("Found pivot !!!");
			return midIndex;
		} else {
			if (midElement < array[low] || array[low] <= array[high]) {
				System.out.println("searching low: " + low + " "
						+ (midIndex - 1));
				return timesSorted(array, low, midIndex - 1);
			} else {
				System.out.println("searching high: " + (midIndex + 1) + " "
						+ high);
				return timesSorted(array, midIndex + 1, high);
			}
		}
	}

	private static int findRotation(int arr[]) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			if (arr[low] <= arr[high]) {
				return low;
			}
			int mid = (low + high) / 2;
			int next = (mid + 1) % arr.length;
			int prev = (mid - 1 + arr.length) % arr.length;
			if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
				return mid;
			} else if (arr[mid] <= arr[high]) {
				high = mid - 1;
			} else if (arr[mid] >= arr[low]){
				low = mid + 1;
			}
		}
		return -1;
	}
}
