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

    public boolean enqueue(int val) {
        if(this.isFull())
            return false;

        // move head and tail one forward (or just 0)
        if(this.isEmpty()) {
            this.head += 1;
            this.tail +=1;
            this.queue[this.tail] = val;
        }
        else {
            
           
            this.tail = (this.tail + 1) % this.maxSize;
            this.queue[this.tail] = val;
        }
        return true;
    }

    public Integer dequeue() {

        // if empty return null
        if(this.isEmpty())
            return null;
        
        // make var for val at head
        Integer valToReturn = this.queue[this.head];


        // if one thing move H/T to -1
        if(this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
        }
        // otherwise move head forward
        this.head = (this.head + 1) % this.maxSize;
            // [13,5,6,7]
            //     T   H   
        return valToReturn;         
    }

}