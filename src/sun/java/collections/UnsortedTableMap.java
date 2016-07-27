package sun.java.collections;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class UnsortedTableMap<K, V> extends AbstractMap<K, V>{
	
	private HashSet<Map.Entry<K,V>> table = new HashSet<>(); 
	
	public UnsortedTableMap(){}

	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return new EntityIterable();
	}
	private class EntityIterable implements Iterable<Entry<K,V>>{

		@Override
		public Iterator<java.util.Map.Entry<K, V>> iterator() {
			return new EntityIterator();
		}
		
	}HashMap
	
	private class EntityIterator implements Iterator<Map.Entry<K,V>>{

		private int j=0;
		@Override
		public boolean hasNext() {
			return j<table.size();
		}

		@Override
		public java.util.Map.Entry<K, V> next() {
			if(j==table.size())
				throw new NoSuchElementException();
			return table.get(j++);
		}
		
	}
	private int findIndex(K key){
		int n = table.size();
		for(int i=0;i<n; i++){
			if(table.get(i).getKey().equals(key))
				return i;
		}
		return -1;
	}
	
	public int getSize(){
		return table.size();
	}

}
