public class Barrel implements Slappable {
    private int energyLevel;
    public int getEnergyLevel() {
        return this.energyLevel;
    }
    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }
    public Barrel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public void getSlapped(int powerLevel) {
        System.out.println("im a barrel slap me!");
        if(this.energyLevel > 5)
		    this.energyLevel -= powerLevel;
	}
}