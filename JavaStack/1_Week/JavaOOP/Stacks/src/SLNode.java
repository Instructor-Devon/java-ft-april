
public class SLNode {
	// what gos here?
	public Integer value;
	public SLNode next;
	public SLNode(int value) {
		this.value = value;
		this.next = null;
	}
	@Override
	public String toString() {
		return String.format("Value: %d", this.value);
	}
}
