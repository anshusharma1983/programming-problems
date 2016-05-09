package test.array;

/*
 http://www.geeksforgeeks.org/find-maximum-average-subarray-of-k-length/
 Given an array with positive and negative numbers, find the maximum average subarray of given length.

 Example:

 Input:  arr[] = {1, 12, -5, -6, 50, 3}, k = 4
 Output: Maximum average subarray of length 4 begins
 at index 1.
 Maximum average is (12 - 5 - 6 + 50)/4 = 51/4

 */
public class MaximumAverageSubarrayOfKLength {
	public static void main(String[] args) {
		int arr[] = { 1, 12, -5, -6, 50, 3 };
		int k = 4;
		maxAverageSubarray(arr, k);
	}

	static void maxAverageSubarray(int[] arr, int k) {
		int maxSum = 0, sum = 0;
		int left = 0, right = 0;
		int startIndex = -1;
		while (right - left != k) {
			maxSum += arr[right++];
		}
		sum = maxSum;
		while (right < arr.length) {
			sum -= arr[left++];
			sum += arr[right++];
			if (sum > maxSum) {
				maxSum = sum;
				startIndex = left;
			}
		}
		System.out.println("Max sum: " + maxSum);
		System.out.println("Starting at index:" + startIndex);
	}
}
