package careercup.chapter3;

import java.util.LinkedList;

public class AnimalShelter2 {
	
	
	public static class Animal{
		String value;
		int order;
		
		public Animal(String value, int order){
			this.value = value;
			this.order = order;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public int getOrder() {
			return order;
		}
		public void setOrder(int order) {
			this.order = order;
		}
		public String toString(){
			return value+"+"+order;
		}
	}
	
	LinkedList<Animal> cats = new LinkedList<Animal>();
	LinkedList<Animal> dogs = new LinkedList<Animal>();

	int order = -1;
	public void enqueue(String type, String animal){
		if(type.equals("dog"))
			dogs.add(new Animal(animal,++order));
		if(type.equals("cat"))
			cats.add(new Animal(animal,++order));
	}
	
	public String dequeueAny(){
		if(dogs.peek().getOrder()<cats.peek().getOrder()){
			return dogs.poll().getValue();
		}else{
			return cats.poll().getValue();
		}
	}
	
	public String dequeueDog(){
		return dogs.poll().getValue();
	}
	
	public String dequeueCat(){
		return cats.poll().getValue();
	}
	public void print(){
		System.out.println(cats);
		System.out.println(dogs);
	}
	public static void main(String args[]){
		AnimalShelter2 animalShelter = new AnimalShelter2();
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
