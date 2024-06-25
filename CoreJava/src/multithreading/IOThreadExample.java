package multithreading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IOThreadExample {
	 public static void main(String[] args) {
	       
	        Thread ioThread = new Thread(() -> {
	            try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Isign/OneDrive/Documents/Assignment1.txt"))) {
	                String line;
	                while ((line = reader.readLine()) != null) {
	                    System.out.println(line);
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        });

	       
	        ioThread.start();
	    }
}
