
public class Application {
	public static void main(String[] args) {
		Gorilla g1 = new Gorilla();
		Gorilla g2 = new Gorilla();
	
		g1.Slap(g2);
		
		g1.displayEnergy();
		g2.displayEnergy();
	}
}
