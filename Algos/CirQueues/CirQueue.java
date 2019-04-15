public class CirQueue {
    private int head;
    private int tail;
    private int maxSize;
    private int[] queue;

    public CirQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new int[maxSize];
        // initialize head and tail to -1
        this.head = -1;
        this.tail = -1;
    }

    public int Front() {
        // value where head is
        if(this.isEmpty())
            return -1;
        return this.queue[head];
    }

    public boolean isEmpty() {
        return this.head == -1;
    }
    public boolean isFull() {
        // if tail is maxSize away from head
        // if head is tail plus one
        return (this.tail + 1) % this.maxSize == this.head;

    }

}