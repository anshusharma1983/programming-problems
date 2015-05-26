import java.text.SimpleDateFormat;
import java.util.Date;

public class DeamonThread {

	public static void main(String[] args) {
		new WorkerThread().start();
		try {
			Thread.sleep(7500);
		} catch (InterruptedException e) {
		}
		System.out.println("Main Thread ending");
		
	}

}

class WorkerThread extends Thread {

	public WorkerThread() {
		setDaemon(false); // When false, (i.e. when it's a user thread),
		// the Worker thread continues to run.
		// When true, (i.e. when it's a daemon thread),
		// the Worker thread terminates when the main
		// thread terminates.
	}

	public void run() {
		int count = 0;
		while (true) {
			System.out.println("Hello from Worker " + count++);
			try {
				sleep(5000);
			} catch (InterruptedException e) {
			}
		}

	}

	// SimpleDateFormat is not thread-safe, so give one to each thread
	private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMdd HHmm");
		}
	};

	public String formatIt(Date date) {
		return formatter.get().format(date);
	}
}