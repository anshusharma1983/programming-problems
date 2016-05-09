package test.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StreamTest {
	public static void main(String[] args) {
		// stream1();

		 System.out.println("Without stream");
		 noStream2();
		 System.out.println("With stream");
		 withStream2();
	}

	private static void withStream2() {
		List<Transaction> txns = createTransactions();
		txns.stream().filter(t -> t.buyer.age >= 65).map(t -> t.seller)
				.distinct().sorted(Comparator.comparing(seller -> seller.name))
				.forEach(seller -> System.out.println(seller.name));

	}

	private static void noStream2() {
		Set<Seller> sellers = new HashSet<>();
		List<Transaction> txns = createTransactions();
		for (Transaction txn : txns) {
			if (txn.buyer.age >= 65) {
				sellers.add(txn.seller);
			}
		}
		List<Seller> sorted = new ArrayList<>(sellers);
		Collections.sort(sorted, new Comparator<Seller>() {
			public int compare(Seller a, Seller b) {
				return a.name.compareTo(b.name);
			}
		});
		for (Seller s : sorted) {
			System.out.println(s.name);
		}
	}

	private static void stream1() {
		List<Transaction> txns = createTransactions();

		// .filter(t -> t.state.equals("NY"))
		// .mapToInt(t -> t.price)
		// .sum();

		int sum = txns.stream().filter(t -> t.state.equals("NY"))
				.mapToInt(t -> t.price).sum();
		System.out.println(sum);
	}

	private static List<Transaction> createTransactions() {
		List<Transaction> txns = new ArrayList<Transaction>();
		txns.add(new Transaction("NY", 5, new Buyer(67), new Seller("aaaaa")));
		txns.add(new Transaction("CO", 5, new Buyer(66), new Seller("bbbbb")));
		txns.add(new Transaction("NY", 8, new Buyer(65), new Seller("ccccc")));
		txns.add(new Transaction("KY", 5, new Buyer(64), new Seller("ddddd")));
		txns.add(new Transaction("MA", 5, new Buyer(63), new Seller("eeeee")));
		txns.add(new Transaction("NY", 2, new Buyer(62), new Seller("fffff")));
		return txns;
	}

	static class Transaction {
		String state;
		int price;
		Buyer buyer;
		Seller seller;

		public Transaction(String state, Integer price, Buyer b, Seller s) {
			this.state = state;
			this.price = price;
			this.buyer = b;
			this.seller = s;
		}
	}

	static class Seller {
		String name;

		public Seller(String name) {
			super();
			this.name = name;
		}
	}

	static class Buyer {
		int age;

		public Buyer(int age) {
			this.age = age;
		}
	}
}
