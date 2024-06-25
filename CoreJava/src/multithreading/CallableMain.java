package multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class CallableMain{
	public static void main(String []args) {
		CallableExample callable=new CallableExample();
		FutureTask<Integer> task=new FutureTask<Integer>(callable);
		Thread thread =new Thread(task);
		thread.start();
		try {
            Integer result = task.get();
            System.out.println("Result from Callable: " + result);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted.");
        } catch (ExecutionException e) {
            System.out.println("Execution exception: " + e.getMessage());
        }
    }
	}
