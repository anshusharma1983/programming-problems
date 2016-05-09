package test.array;

/*
 IMPORTANT !!
 http://www.geeksforgeeks.org/count-frequencies-elements-array-o1-extra-space-time/

 Count frequencies of all elements in array in O(1) extra space and O(n) time
 Given an unsorted array of n integers which can contain integers from 1 to n. 
 Some elements can be repeated multiple times and some other elements can be absent from the array.
  Count frequency of all elements that are present and print the missing elements.

 Examples:

 Input: arr[] = {2, 3, 3, 2, 5}
 Output: Below are frequencies of all elements
 1 -> 0
 2 -> 2
 3 -> 2
 4 -> 0
 5 -> 1

 Input: arr[] = {4, 4, 4, 4}
 Output: Below are frequencies of all elements
 1 -> 0
 2 -> 0
 3 -> 0
 4 -> 4

 Approach - treat elements as indexes, and increment that index (element%n) with n, 
 to get how many times an element was incremented just do element/n
 */
public class FrequencyOfElements {
	public static void main(String[] args) {
		 int arr[] = {2, 3, 3, 2, 5};
//		int arr[] = { 4, 4, 4, 4 };
		// int count[] = new int[arr.length];
		// for (int i = 0; i < count.length; i++) {
		// count[i] = 0;
		// }
		// countFrequency(arr, count);
		// for (int i = 0; i < count.length; i++) {
		// System.out.print(" " + count[i]);
		// }
		printFrequency(arr);
	}

	static void countFrequency(int[] arr, int[] count) {
		for (int i = 0; i < arr.length; i++) {
			count[arr[i] - 1] = count[arr[i] - 1] + 1;
		}
	}

	static void printFrequency(int[] a) {
		int n = a.length;
		for (int j = 0; j < n; j++) {
			a[j] = a[j] - 1;
		}
		for (int i = 0; i < n; i++) {
			int x = Math.abs(a[i] % n);
			System.out.println("Inrementing a[" + x + "] by " + n);
			a[Math.abs(a[i] % n)] = a[Math.abs(a[i] % n)] + n;
		}

		for (int i = 0; i < n; i++) {
			System.out.println("index:" + i + ", value:" + a[i]);
			System.out.println(i + 1 + " -> " + a[i] / n);
		}
	}
}
