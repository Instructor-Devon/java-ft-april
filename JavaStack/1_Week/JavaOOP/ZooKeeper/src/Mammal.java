
public abstract class Mammal implements Slappable {
	protected int energyLevel;

	public static int numMammals = 0;

	public Mammal(int energyLevel) {
		numMammals += 1;
		this.energyLevel = energyLevel;
	}
	
	public static void displayNumMammals() {
		System.out.println(numMammals);
	}


	public abstract void makeSound();


	public int displayEnergy() {
		System.out.println(energyLevel);
		return this.energyLevel;
	}
	public int getEnergyLevel() {
        return this.energyLevel;
    }
    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

	public abstract void getSlapped(int powerLevel);
	
}
