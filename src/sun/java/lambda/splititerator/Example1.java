package sun.java.lambda.splititerator;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example1 {

	public static void main(String[] args) {
		ArrayList<String> list = (ArrayList<String>) Stream.of("test","test2","test3").collect(Collectors.toList());
		Spliterator<String> splitIterator = list.spliterator();
		splitIterator.forEachRemaining(x->System.out.println(x));
	}

}
