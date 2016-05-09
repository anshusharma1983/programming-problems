package test.producer.consumer;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
	/**
	 * worker queue to accept tasks. Task would be added to this queue which
	 * would be performed by any available running thread
	 */
	private BlockingQueue<Runnable> workerQueue;

	/**
	 * Array of running threads that would perform an available task
	 */
	private Thread[] workerThreads;

	/**
	 * Whether threadpool is active and accepting tasks or not
	 */
	private Boolean shutdown = false;

	public ThreadPool(int n) {
		workerQueue = new LinkedBlockingQueue<>();
		workerThreads = new Thread[n];
		for (int i = 0; i < n; i++) {
			workerThreads[i] = new Worker("Pool thread " + i);
			workerThreads[i].start();
		}
	}
	
	public void addTask(Runnable r) {
		try {
			workerQueue.put(r);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void shutdown() {
		while (!workerQueue.isEmpty()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private class Worker extends Thread {

		public Worker(String name) {
			super(name);
		}

		@Override
		public void run() {
			while (!shutdown) {
				try {
					Runnable runnable = workerQueue.take();
					runnable.run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
