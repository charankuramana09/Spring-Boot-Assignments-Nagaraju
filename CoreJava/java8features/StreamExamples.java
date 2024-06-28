package java8features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {

	public static void main(String[] args) {
		List<String> list=Arrays.asList("apple","banana","cherry","apple");
		Stream<String> stream=list.stream();
//		stream.forEach(System.out::println);
		
		//animal name start with D letter
		List<String> animals = Arrays.asList("dog", "cat", "rabbit", "lion","donkey");
		animals.stream()
		      .filter(s -> s.startsWith("d"))
		      .forEach(System.out::println); 
		
		//length of the each animal name
		animals.stream().map(String::length).forEach(System.out::println);
		
		//remove duplicate elements
		stream.distinct().forEach(System.out::println);
		
		//Ascending order elements
		animals.stream()
	      .sorted()
	      .forEach(System.out::println);
		
		//Descending Order elements
		animals.stream().sorted(Comparator.reverseOrder())
		.forEach(System.out::println);
		
		//perform an action for each element
		
		animals.stream()
//	      .peek(System.out::println) 
	      .map(String::toUpperCase)
	      .forEach(System.out::println);
		
		//skip the first element
		animals.stream()
	      .skip(2)
	      .forEach(System.out::println); 
		
		//convert the stream to a collection
		List<String> collectedList = animals.stream().collect(Collectors.toList());
		System.out.println(collectedList); 
		
		//Count the number of elements
		long count=animals.stream().count();
		System.out.println(count);
		
		// Find the first element
		Optional<String> first=animals.stream().findFirst();
		first.ifPresent(System.out::println);
	}
}
