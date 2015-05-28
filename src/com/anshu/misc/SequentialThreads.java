package test.misc;
import java.util.concurrent.atomic.AtomicInteger;

public class SequentialThreads {
	static Object lock1 = new Object();
	static Object lock2 = new Object();
	static Object lock3 = new Object();

	public static class PrintSequential extends Thread {
		private AtomicInteger i;

		// private static Object lock = new Object();

		public PrintSequential(String name, AtomicInteger i) {
			super(name);
			this.i = i;
		}

		public void run() {
			while (true) {
				System.out.println(getName() + ":" + i.incrementAndGet());
				try {
					if (getName().equals("t1")) {
						synchronized (lock2) {
							lock2.notify();
						}
						synchronized (lock1) {
							lock1.wait();
						}
					} else if (getName().equals("t2")) {
						synchronized (lock3) {
							lock3.notify();
						}
						synchronized (lock2) {
							lock2.wait();
						}
					} else if (getName().equals("t3")) {
						synchronized (lock1) {
							lock1.notify();
						}
						synchronized (lock3) {
							lock3.wait();
						}
					}
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		AtomicInteger i = new AtomicInteger(0);
		PrintSequential t1 = new PrintSequential("t1", i);
		PrintSequential t2 = new PrintSequential("t2", i);
		PrintSequential t3 = new PrintSequential("t3", i);
		t1.start();
		Thread.sleep(1000);
		t2.start();
		Thread.sleep(1000);
		t3.start();
		Thread.sleep(1000);
	}

}
