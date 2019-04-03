public class Gorilla extends Mammal {
	public Gorilla() {
		super(100);
	}
	public Gorilla(int energyLevel) {
		super(energyLevel);
	}
	public void makeSound() {
		System.out.println("GROORRR");
	}
	public void throwSomething() {
		// print that something is thrown
		System.out.println("I am a gorilla that is throwing something");
		this.energyLevel-=5;
	}
	public void eatBananas() {
		System.out.println("I am a gorilla that is quite satified with my bananas");
		this.energyLevel += 10;
	}

	public void getSlapped(int powerLevel) {
        this.makeSound();
        this.energyLevel -= powerLevel;
	}

	public void Slap(Slappable target) {
		target.getSlapped(5);
		this.energyLevel += 5;
		System.out.println("SLAPPING FOR 5 POINTS");
	}

	public void SlapMany(Slappable[] targets) {
		for(Slappable target: targets) {
			target.getSlapped(5);
		}
	}
}
