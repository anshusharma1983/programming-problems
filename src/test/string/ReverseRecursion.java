package test.string;

public class ReverseRecursion {
	public static void main(String[] args) {
		reverse("Anshul".toCharArray(), 0);
	}

	static void reverse(char[] s, int k) {
		if (k > s.length / 2) {
			System.out.println(s);
			return;
		}
		StringUtils.swap(s, k, s.length - k - 1);
		reverse(s, k + 1);
	}
}
