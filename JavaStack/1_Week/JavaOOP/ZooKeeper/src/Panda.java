public class Panda extends Mammal {
    public Panda() {
        super(75);
    }

    public void makeSound() {
        System.out.println("errriirrer");
    }

    public void getSlapped(int powerLevel) {
        this.makeSound();
        this.energyLevel -= powerLevel;
	}
}