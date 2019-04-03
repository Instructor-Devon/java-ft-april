
public class Gorilla extends Mammal {
	public Gorilla() {
		super(100);
	}
	public Gorilla(int energyLevel) {
		super(energyLevel);
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
	
	public void Slap(Gorilla target) {
		target.energyLevel -= 5;
		this.energyLevel += 5;
		System.out.println("SLAPPING FOR 5 POINTS");
	}
	// slap another gorilla, steal 5 energy points
	
}
