public class Window implements Slappable {
    private int energyLevel;
    public Window() {
        this.energyLevel = 10;
    }
    public int getEnergyLevel() {
        return this.energyLevel;
    }
    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }
    public void getSlapped(int powerLevel) {
		System.out.println("SCHSHHHHHHHHH");
		this.energyLevel -= powerLevel;
	}
}