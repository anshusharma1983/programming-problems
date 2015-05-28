package test.misc;
public class SequentialThreads2 {
	public static class ThreadCount extends Thread {
		private static int value = 0;

		public ThreadCount() {
			start();
		}

		public void run() {
			System.out.println("started thread:" + getName());
			while (true) {
				synchronized (this) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(getName() + ":" + ++value + " ");

				}
			}
		}
	}

	public static void main(String[] args) {
		int count = 3;
		ThreadCount arr[] = new ThreadCount[3];
		for (int i = 0; i < count; i++) {
			arr[i] = new ThreadCount();
		}
		while (true) {
			for (int i = 0; i < count; i++) {
				synchronized (arr[i]) {
					arr[i].notify();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}
}
