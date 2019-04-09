import java.util.ArrayList;

public class Application {
	public static void main(String[] args) {
		ArrayList<Integer> listy = new ArrayList<Integer>();
		listy.add(5);
		listy.add(10);
		listy.add(56);
		
		int[] numbers = {43,3456,34,45};
		
		Person<String> personWithString = new Person<String>("Jenny", "hoo");
		Person<Integer> personWithInt = new Person<Integer>("Devon", 13);
		
		personWithString.displaySecret();
		personWithInt.displaySecret();
		// [5, 10, 56]
		System.out.println(listy);
		System.out.println(numbers);

	}
}
