package careercup.chapter3;

import java.util.LinkedList;

public class AnimalShelter {
	
	LinkedList<Integer> indexCats = new LinkedList<Integer>();
	LinkedList<Integer> indexDogs = new LinkedList<Integer>();

	LinkedList<String> animals = new LinkedList<>();
	
	int index = -1;
	public void enqueue(String type, String animal){
		if(type.equals("dog"))
			indexDogs.add(++index);
		if(type.equals("cat"))
			indexCats.add(++index);
		animals.add(index,animal);
	}
	
	public String dequeueAny(){
		if(!animals.isEmpty())
			index--;
		return animals.poll();
	}
	
	public String dequeueDog(){
		return animals.remove((int)indexDogs.poll());
	}
	
	public String dequeueCat(){
		return animals.remove((int)indexCats.poll());
	}
	public void print(){
		System.out.println(animals);
	}
	public static void main(String args[]){
		AnimalShelter animalShelter = new AnimalShelter();
		animalShelter.enqueue("cat", "c1");
		animalShelter.enqueue("cat", "c2");
		animalShelter.enqueue("dog", "d1");
		animalShelter.enqueue("cat", "c3");
		animalShelter.enqueue("cat", "c4");
		animalShelter.enqueue("dog", "d2");
		animalShelter.dequeueAny();
		animalShelter.dequeueCat();
		animalShelter.print();
	}
	
}
