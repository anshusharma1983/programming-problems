package test.array;

/**
 * Incomplete
 * @author Anshu
 *
 */
public class PrintPartitions {

	static void printPartitions(int n, int start) {
		System.out.println("\nDEBUG: " + n + ":" + start);
		if (n == 1) {
			System.out.print(1);
			return;
		}
		if (n == start) {
			System.out.print(start);
			System.out.println();
			printPartitions(n, start - 1);
		} else {
			System.out.print(start);
			printPartitions(n - start, n-start);
		}

	}

	static int index;

	public static void main(String[] args) {
		index = 5;
		printPartitions(5, 5);
	}
}
