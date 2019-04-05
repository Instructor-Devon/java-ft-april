import java.util.ArrayList;

public class Application {
	public static void main(String[] args) {
		Gorilla g1 = new Gorilla();
		Panda p1 = new Panda();
		Panda p2 = new Panda();
		Barrel b1 = new Barrel(100);
		Window w1 = new Window();

		Mammal.displayNumMammals();
		
		Slappable[] manyThings = 
		{
			p1, b1, w1
		};
		// value type
		int x = 5;
		// object
		Integer y = 5;
		
		ArrayList<Integer> listy = new ArrayList<Integer>();
		listy.add(5);
		listy.add(10);
	
	

	}
}
