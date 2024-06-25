package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

 class CallableExample implements Callable<Integer>{
	public Integer call() {
		return 123;
	}

}

 