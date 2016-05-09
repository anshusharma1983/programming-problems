package test.list;

import java.util.List;

public class ListUtil {
	public static void printList(List<Integer> list) {
		System.out.println();
		for (Integer i : list) {
			System.out.print(" " + i);
		}
		System.out.println();
	}
}
