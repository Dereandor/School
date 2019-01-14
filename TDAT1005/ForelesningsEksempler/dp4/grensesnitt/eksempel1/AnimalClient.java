package dp4.grensesnitt.eksempel1;

public class AnimalClient {

	public static void main(String args[]) {

		Dog d = new Dog();
		d.eat();
		d.travel();

		Cat c = new Cat();
		c.eat();
		c.travel();

		Animal animalDog = (Animal) new Dog();
		animalDog.eat();
		animalDog.travel();

		Animal animalCat = (Animal) new Cat();
		animalCat.eat();
		animalCat.travel();
	}
}
