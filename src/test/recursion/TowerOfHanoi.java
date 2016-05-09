package test.recursion;

/*
 Move n disks from A to C using B as intermediate
 */
public class TowerOfHanoi {
	public static void main(String[] args) {
		int n = 4;
		towerOfHanoi(n, "A", "B", "C");
	}

	static void towerOfHanoi(int n, String a, String b, String c) {
		if (n == 0)
			return;
		towerOfHanoi(n - 1, a, c, b);
		System.out.println("Moved disk from " + a + " to " + c);
		towerOfHanoi(n - 1, b, a, c);
	}
}
