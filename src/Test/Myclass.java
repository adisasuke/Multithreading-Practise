package Test;

import java.util.List;

public class Myclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	List<String> list = List.of("apple","mango","guava");
	
	list.stream()
	.map(String::toUpperCase)
	.distinct()
	.forEach(System.out::println);
	}
	
}
