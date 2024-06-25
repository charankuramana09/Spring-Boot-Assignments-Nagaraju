package multithreading;

public class CPUThreadExample {
	 public static void main(String[] args) {
	      
	        Thread cpuThread = new Thread(() -> {
	            long sum = 0;
	            for (int i = 0; i < 1_000_000; i++) {
	                sum += i;
	            }
	            System.out.println("Sum: " + sum);
	        });

	       
	        cpuThread.start();
	    }
}
