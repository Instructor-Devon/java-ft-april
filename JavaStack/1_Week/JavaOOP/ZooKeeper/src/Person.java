
public class Person<T> {
	private String firstName;
	
	private T secret;
	
	public Person(String firstName, T secret) {
		this.firstName = firstName;
		this.secret = secret;
	}
	
	public void displaySecret() {
		System.out.println(this.secret);
	}
}
