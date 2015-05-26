package test.array;

class PrintKClosestOfN {

	public static void printClosestNPointsOf(int[] ints, int count, int item) {
		int index = binarySearch(ints, item);
		int i = 0, j = 0;
		if (index < 0) { // not found.. so can't skip index
			index = -index + 1;
			i = index;
		} else { // found.. so skip index.
			i = index - 1;
		}
		j = index + 1;

		while (count > 0) {
			if ((i < 0 && j < ints.length - 1)
					|| (Math.abs(ints[i] - item) >= Math.abs(ints[j] - item))) {
				System.out.println(ints[j++]);
			} else if ((j >= ints.length && i >= 0)
					|| (Math.abs(ints[i] - item) < Math.abs(ints[j] - item))) {
				System.out.println(ints[i--]);
			} else {
				System.out.println("no more");
				break;
			}
			count--;

		}
	}

	private static final int binarySearch(int[] ints, int key) {
		int mid, high, low;
		high = ints.length - 1;
		low = 0;
		while (low <= high) {
			mid = (high + low) / 2;
			if (ints[mid] == key) {
				return mid;
			}
			if (key < ints[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}
		return -low - 1;
	}

	public static void main(String[] args) throws java.lang.Exception {
		int[] arr = { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56 };
		int k = 4, x = 35;
		printClosestNPointsOf(arr, k, x);
	}
}
