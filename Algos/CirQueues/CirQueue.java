
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
    public void grow(int newSize) throws IllegalArgumentException {
        // TODO: make new array with [newSize]
        int[] newQueue = new int[newSize];

        if(newSize < this.maxSize)
            throw new IllegalArgumentException("Size must be larger than existing size");

        if(isEmpty()) {
            this.maxSize = newSize;
            this.queue = newQueue;
            return;
        }
        // get values from old array on over to new array
        // maintain integrity of queue

        int count = 0;
        int newHead;
        int newTail;
        // loop starting at head
        // increment count
        // do this: newQueue[count] = this.queue[i]
        int i;
        for(i = this.head; i != this.tail; i = (i + 1) % this.maxSize) {
            newQueue[count] = this.queue[i];
            count++;
        }
        newQueue[count] = this.queue[i];
        newTail = count;
        newHead = 0;
        // one last thing with this.queue[i]

        // [23,24,25,26]
        //     HT

        // [26,23,24,0,0,0,0]
        //  H     T


        this.head = newHead;
        this.tail = newTail;
        this.queue = newQueue;
        this.maxSize = newSize;
    }
    public int front() {
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

    public int size() {
        // STEP 1

        if(this.isEmpty())
            return 0;

        int count = 0;


        for(int i = this.head; i != this.tail; i = (i + 1) % this.maxSize) {
            count++;
        }
        // q [0,0,0,0,0]
        //    T   H    
        return count + 1;
        
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
        else {
            // otherwise move head forward
            this.head = (this.head + 1) % this.maxSize;
        }
            // [13,5,6,7]
            //     T   H   
        return valToReturn;         
    }

    public void display() {
        // if empty: "Queue is Empty"
        // if full: "Queue is Full"
        // Head: X
        // Tail: Y
        // Size: Z
        // Each Value
        if(isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        if(isFull()) {
            System.out.println("Queue is Full");
        }

        System.out.println(String.format("Head: %d", this.head));
        System.out.println(String.format("Tail: %d", this.tail));
        System.out.println(String.format("Size: %d", this.size()));

        // loop array
        // [3,2,5,46]
        int pos = 0;
        int i;
        for(i = this.head; i != this.tail; i = (i + 1) % this.maxSize) {
            System.out.println(String.format("Pos: %d, Value: %d", pos, this.queue[i]));
            // Pos: 0, Value: 1
            pos++;
        }
        System.out.println(String.format("Pos: %d, Value: %d", pos, this.queue[i]));



    }

}