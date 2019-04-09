
public class SLStack {
	private SLNode head;
	
	public SLStack() {
		this.head = null;
	}
	// push
	// add to front
	public void push(int val) {
		SLNode newThing = new SLNode(val);
		
		// attach newThing to head
		newThing.next = this.head;
		// assign newTHing as head
		this.head = newThing;
		
	}
	// pop
	public Integer pop() {
		if(head == null)
			return null;
		
		int nowVal = this.head.value;
		this.head = this.head.next;
		return nowVal;
		
	}
	// display values
	public void displayValues() {
		for(SLNode runner = this.head; runner != null; runner = runner.next) {
			System.out.println(runner.toString());
		}
	}
	// contains (search for value)
	public boolean contains(Integer searchVal) {
		for(SLNode runner = this.head; runner != null; runner = runner.next) {
			if(searchVal == runner.value) {
				return true;
			}
		}
		return false;
	}
	
	
}
