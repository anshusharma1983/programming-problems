package test.array;

/*
 http://www.geeksforgeeks.org/count-strictly-increasing-subarrays/
 Count Strictly Increasing Subarrays
 Given an array of integers, count number of subarrays (of size more than one) that are strictly increasing.
 Expected Time Complexity : O(n)
 Expected Extra Space: O(1)

 Examples:

 Input: arr[] = {1, 4, 3}
 Output: 1
 There is only one subarray {1, 4}

 Input: arr[] = {1, 2, 3, 4}
 Output: 6
 There are 6 subarrays {1, 2}, {1, 2, 3}, {1, 2, 3, 4}
 {2, 3}, {2, 3, 4} and {3, 4}

 Input: arr[] = {1, 2, 2, 4}
 Output: 2
 There are 2 subarrays {1, 2} and {2, 4}
 */
public class CountIncreasingSubArrays {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		System.out.println(countIncreasing(arr));
	}

	// not working correctly, it does not handle 1, 2, 3, 4 as it cannot
	// calculate 2,3 as a result
	static int countSubArrays(int[] arr) {
		int count = 0;
		int left = 0, right = 0;
		while (left < arr.length - 1) {
			if (right == arr.length - 1) {
				// breaking condition
				if (left < right) {
					count += right - left - 1;
					left = arr.length;
				}
			} else if (arr[right + 1] > arr[right]) {
				// right one is increasing we can increment
				right++;
				count++;
			} else if (arr[right + 1] <= arr[right]) {
				// right cannot be incremented, check if left can be incremented
				if (left < right) {
					if (right - left > 1) {
						count++;
					}
					left++;
				} else {
					// left == right
					left++;
					right++;
				}
			}
		}
		return count;
	}

	/*
	 * method - the length l would give l * (l-1)/ 2 substrings
	 * 
	 * @param arr
	 * 
	 * @return
	 */
	static int countIncreasing(int[] arr) {
		int count = 0;
		int len = 1;
		for (int i = 0; i < arr.length; i++) {
			if (i < arr.length - 1 && arr[i + 1] > arr[i]) {
				len++;
			} else {
				count += (len * (len - 1)) / 2;
				len = 1;
			}
		}
		if (len > 1) {
			count += (len * (len - 1)) / 2;
		}
		return count;
	}

}
