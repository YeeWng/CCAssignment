package ch3;

import java.util.LinkedList;

public class Solution36 {
	/**
	 * According to the question animal is designed as abstract calss,
	 * because there are two specific animals cat and dog have some common
	 * attributes.
	 * 
	 * @author Matrix
	 *
	 */
	public static abstract class Animal {
		// rank is the order key word
		private int rank;
		protected String name;
		public Animal(String name) {
			this.name = name;
		}
		
		public void setRank(int r) {
			rank = r;
		}
		
		public int getRank() {
			return rank;
		}
		
		public boolean isHigherThan(Animal a) {
			return this.rank < a.getRank();
		}
	} 
	
	/**
	 * Dog extends from Animal
	 * 
	 * @author Matrix
	 *
	 */
	public static class Dog extends Animal {
		public Dog(String n) {
			super(n);
		}
	}
	
	/**
	 * Cat extends from Animal
	 * 
	 * @author Matrix
	 *
	 */
	public static class Cat extends Animal {
		public Cat(String n) {
			super(n);
		}
	}
	
	/**
	 * Simulation queue with two LinkedList
	 * Time Complexity: the same as usual queue
	 * Space Complexity: the same as usual queue
	 * 
	 * @author Matrix
	 *
	 */
	public static class AnimalQueue {
		LinkedList<Dog> dogs = new LinkedList<Dog>();
		LinkedList<Cat> cats = new LinkedList<Cat>();
		
		private int rank = 0;
		
		public boolean isEmpty() {
			return (dogs.size()==0 && cats.size() ==0);
		}
		
		public void enqueue(Animal a) {
			a.setRank(rank++);
			if (a.name.contains("dog"))
				dogs.addLast((Dog) a);
			else if (a.name.contains("cat"))
				cats.addLast((Cat)a);
		}
		
		public Animal dequeueAny() {
			if (dogs.size() == 0) {
				return dequeueCats();
			} else if (cats.size() == 0) {
				return dequeueDogs();
			}
			
			Dog dog = dogs.peek();
			Cat cat = cats.peek();
			if (dog.isHigherThan(cat)) {
				return dequeueDogs();
			} else {
				return dequeueCats();
			}
		}
		
		public Dog dequeueDogs() {
			return dogs.poll();
		}
		
		public Cat dequeueCats() {
			return cats.poll();
		}
		
		public void print() {
			if (!isEmpty()) {
				System.out.print(dequeueAny().name + " -> ");
			}	
		}
	}
	
	public static void main(String[] args) {
		/**
		 * Testing case
		 */
		AnimalQueue animal = new AnimalQueue();
		
		String[] cas1Cats = {"cat1", "cat2", "cat3", "cat4", "cat5"};
		for (String s : cas1Cats) {
			Cat c = new Cat(s);
			animal.enqueue(c);
		}
		String[] cas1Dogs = {"dog1", "dog2", "dog3", "dog4"};
		for (String s : cas1Dogs) {
			Dog d = new Dog(s);
			animal.enqueue(d);
		}
		
		Animal a1 = animal.dequeueDogs();
		System.out.println(a1.name + " is removed from the queue: ");
		Animal a2 = animal.dequeueCats();
		System.out.println(a2.name + " is removed from the queue:");
		Animal a3 = animal.dequeueAny();
		System.out.println(a3.name + " is removed from the queue:");
		Animal a4 = animal.dequeueAny();
		System.out.println(a4.name + " is removed from the queue:");
	}
}
