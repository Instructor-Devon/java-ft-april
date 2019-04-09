
public class StackTester {
	public static void main(String[] args) {
		SLStack stack = new SLStack();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		stack.displayValues();
		
		System.out.println(stack.contains(10));
		System.out.println(stack.contains(1));
	}
}
