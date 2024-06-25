package multithreading;

 class MyRunnable implements Runnable{

	public void run() {
		System.out.println("Thread is running");
	}
}


public class Main {

	public static void main(String[] args) {
		 MyRunnable runnable = new MyRunnable();
		Thread thread =new Thread(runnable);
		thread.start();

	}

}
