
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
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public int size() {
		int count = 0;
		if(this.isEmpty())
			return count;
		
		// otherwise... 
		for(SLNode runner = this.head; runner != null; runner = runner.next) {
			count++;
		}
		return count;
	}
	public Integer minValue() {
		if(this.isEmpty())
			return null;
		int min = this.head.value;
		for(SLNode runner = this.head; runner != null; runner = runner.next) {
			if(min > runner.value)
				min = runner.value;
		}
		return min;
	}
	public void removeMins() {
		//Remove a Stack’s minimum value, otherwise leaving values in order. 
		//If duplicate min values are found, remove them all
		Integer min = this.minValue();
		
		if(min == null)
			return;
		
		
		if(this.head.next == null) {
			this.head = null;
			return;
		}
			
		SLNode runner = this.head;
		// loop until runner.next.value == min
		// keep going until we reached end of stack
		while(runner.next != null) {
			if(runner.next.value == min)
				runner.next = runner.next.next;
			
			if(runner.next.value != min)
				runner = runner.next;
		}
		
		
	}
	// [1,3,3,4,3,3,1] => true
	// [1] => true
	// [1,2] => false
	// [1,2,2,1] => true
	
	public boolean isPalindrome() {
		// find midpoint
		int midpoint = this.size()/2;
		int count = 0;
		SLStack helper = new SLStack();
		
		if(this.isEmpty() || this.head.next == null)
			return true;
		
		SLNode runner = this.head;
		SLNode walker = helper.head;
		// [1,2,2,1]
		//     [2,1]
		while(runner != null) {
			if(count < midpoint) {
				helper.push(runner.value);
				walker = helper.head;
			}
			else {
				// compare helper vals to runner vals
				if(runner.value != walker.value)
					return false;
				walker = walker.next;
			}
			runner = runner.next;
			count++;
		}
		
		return true;
	}
	
	public static boolean compareTwoStacks(SLStack one, SLStack two) {
		 //TODO: compare the size!
		if(one.size() != two.size())
			return false;
		SLNode currOne = one.head;
		SLNode currTwo = two.head;
		// traverse both nodes, comparing values
		// fail fast if values not same!
		while(currOne != null) {
			if(currOne.value != currTwo.value) {
				return false;
			}
			currOne = currOne.next;
			currTwo = currTwo.next;				
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
