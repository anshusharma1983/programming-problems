package test.array;


/*
 http://www.geeksforgeeks.org/find-zeroes-to-be-flipped-so-that-number-of-consecutive-1s-is-maximized/

 Given a binary array and an integer m, find the position of zeroes flipping which creates maximum number of consecutive 1s in array.

 Examples:

 Input:   arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
 m = 2
 Output:  5 7
 We are allowed to flip maximum 2 zeroes. If we flip
 arr[5] and arr[7], we get 8 consecutive 1's which is
 maximum possible under given constraints 

 Input:   arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
 m = 1
 Output:  7
 We are allowed to flip maximum 1 zero. If we flip 
 arr[7], we get 5 consecutive 1's which is maximum 
 possible under given constraints.

 Input:   arr[] = {0, 0, 0, 1}
 m = 4
 Output:  0 1 2
 Since m is more than number of zeroes, we can flip
 all zeroes.

 */
public class FlipZerosMaximizeOnes {
	/*
	 * Caterpillar method
	 */
	public static void main(String[] args) {

	}

	public static void flipZeros(int[] A, int m) {
		int startIndex, endIndex, bestWindow = 0;
		startIndex = -1;
		endIndex = -1;

		for (int i = 0; i < A.length; i++) {
			while (m > 0 && A[i] == 0) {
				
			}
		}
	}
	
	
}
