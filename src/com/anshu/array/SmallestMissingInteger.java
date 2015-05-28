package test.array;

/**
 * 
 * Find the smallest positive integer value that cannot be represented as sum of
 * any subset of a given array
 * 
 * Given a sorted array (sorted in non-decreasing order) of positive numbers,
 * find the smallest positive integer value that cannot be represented as sum of
 * elements of any subset of given set. Expected time complexity is O(n).
 * 
 * Examples:
 * 
 * Input: arr[] = {1, 3, 6, 10, 11, 15}; Output: 2
 * 
 * Input: arr[] = {1, 1, 1, 1}; Output: 5
 * 
 * Input: arr[] = {1, 1, 3, 4}; Output: 10
 * 
 * Input: arr[] = {1, 2, 5, 10, 20, 40}; Output: 4
 * 
 * Input: arr[] = {1, 2, 3, 4, 5, 6}; Output: 22
 * 
 * @author Anshu
 * 
 */
public class SmallestMissingInteger {

	public static void main(String[] args) {
//		Integer[] arr = { 1, 2, 3, 4, 5, 6 };
//		System.out.println(findSmallest(arr));
		System.out.println(isOdd(19));
	}

	public static Integer findSmallest(Integer[] arr) {
		int res = 1;
		for (int i = 0; i < arr.length && arr[i] <= res; i++) {
			res += arr[i];
		}
		return res;
	}
	
	private static Integer isOdd(Integer i) {
		return (i & 0x01);
	}
}
