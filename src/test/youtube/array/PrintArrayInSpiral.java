package test.youtube.array;

public class PrintArrayInSpiral {
	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3, 4 }, 
				 		{ 5, 6, 7, 8 }, 
				 		{ 9, 10, 11, 12 },
				 		{ 13, 14, 15, 16 } };
		printSpiral(arr);
	}

	private enum DIRECTION {
		RIGHT, DOWN, LEFT, UP
	}

	private static void printSpiral(int[][] arr) {
		int L = 0, R = arr.length - 1, T = 0, B = arr.length - 1;
		DIRECTION dir = DIRECTION.RIGHT;
		while (L <= R && T <= B) {
			if (dir == DIRECTION.RIGHT) {
				for (int i = L; i <= R; i++) {
					System.out.print(arr[T][i] + " ");
				}
				dir = DIRECTION.DOWN;
				T++;
			} else if (dir == DIRECTION.DOWN) {
				for (int i = T; i <= B; i++) {
					System.out.print(arr[i][R] + " ");
				}
				dir = DIRECTION.LEFT;
				R--;
			} else if (dir == DIRECTION.LEFT) {
				for (int i = R; i >= L; i--) {
					System.out.print(arr[B][i] + " ");
				}
				dir = DIRECTION.UP;
				B--;
			} else if (dir == DIRECTION.UP) {
				for (int i = B; i >= T; i--) {
					System.out.print(arr[i][L] + " ");
				}
				dir = DIRECTION.RIGHT;
				L++;
			}
		}
	}
}
