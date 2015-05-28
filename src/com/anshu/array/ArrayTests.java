package test.array;

import java.util.Arrays;

public class ArrayTests {

	/**
	 * 
	 Find next greater number with same set of digits
	 * 
	 * Given a number n, find the smallest number that has same set of digits as
	 * n and is greater than n. If x is the greatest possible number with its
	 * set of digits, then print Ònot possibleÓ.
	 * 
	 * Examples: For simplicity of implementation, we have considered input
	 * number as a string.
	 * 
	 * Input: n = "218765" Output: "251678"
	 * 
	 * Input: n = "1234" Output: "1243"
	 * 
	 * Input: n = "4321" Output: "Not Possible"
	 * 
	 * Input: n = "534976" Output: "536479"
	 * 
	 * @return
	 */

	public static void main(String[] args) {
		// nextGreatest();
		// int[] arr = new int[] {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
		// moveZerorsToRight(arr);
		// printArr(arr);
		// swap(5, 3);
//		printBinary(512);
		nextGreatest2(new int[]{1, 2, 3, 4, 5});
		nextGreatest2(new int[]{2, 1, 8, 7, 6, 5});
		nextGreatest2(new int[]{5, 4, 3, 2, 1});
	}

	public static void printBinary(int n) {
		System.out.println(Math.pow(2, 15));
		for (int i = (int) Math.pow(2, 15); i >= 1;) {
			if ((i & n) > 0) {
				System.out.print("1");
			} else {
				System.out.print("0");
			}
			i >>= 1;
		}
	}

	public static void swap(int a, int b) {
		a = (a + b) - (b = a);
		System.out.println(a + " " + b);
	}

	public static void nextGreatest() {
		// 218765 // 251678
		// 534976 // 536479
		int a[] = { 2, 1, 8, 7, 6, 5 };
		// if all numbers are descending - Not possible
		// if all are ascending, replace last 2 (this would be reached by our
		// algo as well)
		for (int i = a.length - 1; i >= 0; i--) {
			if (i < a.length - 1 && a[i] < a[i + 1]) {
				System.out.println("found " + a[i] + " > " + a[i + 1]);
				// find the smallest in i+1 to end
				System.out.println("finding min from " + (i + 1) + " to "
						+ (a.length - 1));
				int min = a.length - 1;
				for (int j = i + 1; j < a.length; j++) {
					if (a[j] < a[min]) {
						min = j;
					}
				}
				System.out.println("found min " + a[min]);
				// swap a[i] with min
				int tmp = a[i];
				a[i] = a[min];
				a[min] = tmp;
				System.out.println("After swap ");
				printArr(a);
				// sort asc from a[i+1] to end
				System.out.println("Sorting from " + (i + 1) + " to "
						+ (a.length - 1));
				Arrays.sort(a, i + 1, a.length);
				System.out.println("final - ");
				printArr(a);
				return;
			}
		}
	}

	private static void moveZerorsToRight(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0 && i < arr.length - 1) {
				int j = i + 1;
				while (arr[j] == 0 && j < arr.length - 1) {
					j++;
				}
				// swap arr[i] and arr[j]
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
	}

	public static void printArr(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void nextGreatest2(int[] a) {
		System.out.println("finding next greater than:");
		printArr(a);
		/**
		 * 218765 215678
		 * 
		 * 12345 12354
		 * 
		 * 543231 543312
		 * 
		 */
		for (int i = 0; i < a.length; i++) {
			// move forward till you find next number greater than i
			if (i == a.length - 1) {
				// could not find any number greater. The numbers were in descending order
				System.out.println("Not possible");
				return;
			}else {
				if (a[i+1] > a[i]) {
					if (i+1 == a.length-1) {
						// all numbers were in ascending order. Swap last 2 digits and print the number
						a = swap(a,i,i+1);
						printArr(a);
						return;
					}else {
						// found i+1 is greater than i and is not the last digit. Find the smallest number from i+1 till end.
						int s = findSmallest(a, i+1, a.length -1);
						System.out.println("Smallest: " + a[s]);
						a = swap(a, s, i+1);
						if (i+1 < a.length - 1) {
							// if i+1 is not the last digit, sort rest in ascending order
							Arrays.sort(a, i+1, a.length -1);
						}
						printArr(a);
						return;
					}
				}
			}
		}
	}

	private static int findSmallest(int[] a, int i, int j) {
		int smallest = Integer.MAX_VALUE;
		int si = -1;
		for (int k = i; k <=j; k++) {
			if (a[k] < smallest) {
				smallest = a[k];
				si = k;
			}
		}
		return si;
	}

	private static int[] swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		return a;
	}

}
