package test.array;

public class PrintAllPathsMatrix {
	static int MAX_ROWS = 5;
	static int MAX_COLS = 4;
	/**
	 * 1 2 3 4 5 6 7 8
	 * 
	 */
	static int paths[] = new int[MAX_ROWS + MAX_COLS - 1];
	static int[][] matrix = { 
			{ 1, 2, 3, 4 },
			{ 5, 6, 7, 8 },
			{ 5, 6, 7, 8 } ,
			{ 5, 6, 7, 8 } ,
			{ 5, 6, 7, 8 } 
		};

	private static void traverseMatrix(int i, int j, int pi) {
		if (i == MAX_ROWS - 1 && j == MAX_COLS - 1) {
			paths[pi] = matrix[i][j];
			printPaths(pi);
//			System.out.println(matrix[i][j]);
			return;
		}
		paths[pi] = matrix[i][j];
//		System.out.print(matrix[i][j]);
		if (i < MAX_ROWS - 1) {
			traverseMatrix(i + 1, j, pi + 1);
		}
		if (j < MAX_COLS - 1) {
			traverseMatrix(i, j + 1, pi + 1);
		}

	}

	private static void printPaths(int pi) {
		for (int i = 0; i <= pi; i++) {
			System.out.print(paths[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		traverseMatrix(0, 0, 0);
		System.out.println("total paths" + numberOfPaths(4, 5));
//		printArr();
	}

	private static void printArr() {
		for (int i = 0; i < paths.length; i++) {
			System.out.print(paths[i]);
		}
	}
	
	private static int  numberOfPaths(int m, int n){
	   // If either given row number is first or given column number is first
	   if (m == 1 || n == 1)
	        return 1;
	   // If diagonal movements are allowed then the last addition
	   // is required.
	   return  numberOfPaths(m-1, n) + numberOfPaths(m, n-1);
	           // + numberOfPaths(m-1,n-1);
	}
}
