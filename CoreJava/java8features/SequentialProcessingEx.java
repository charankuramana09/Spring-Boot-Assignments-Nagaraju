package java8features;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SequentialProcessingEx {

	public static void main(String[] args) {
		
		 List<Integer> preOpe = IntStream.range(0, 1000000)
                 .boxed()
                 .collect(Collectors.toList());


List<Integer> postOpe = preOpe.stream() 
               .map(e -> e + e) 
               .sorted() 
               .filter(e -> e % 2 == 0) 
               .collect(Collectors.toList()); 

// Print some results for verification
System.out.println("Size of postOpe (sequential): " + postOpe.size()); 
System.out.println("First 10 elements (sequential): " + postOpe.subList(0, 10));
		
	}

}
