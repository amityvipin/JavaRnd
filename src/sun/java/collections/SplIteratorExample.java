package sun.java.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.*;

public class SplIteratorExample {
	
	public static void main(String args[]){
		ArrayList<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		
		//using iterator
		Hashtable test = new Hashtable();
		test.put("test",null);
		Iterator<String> i = list.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
		//using List Iterator
		ListIterator<String> li = list.listIterator();
		while(li.hasNext()){
			System.out.println(li.next());
		}
		//using spliterator
		Spliterator<String> spli = list.spliterator();
		//eclipse is supporting java 8 syntex currently
		//while(spli.tryAdvance((n) -> System.out.println(n)));
			
	}

}
