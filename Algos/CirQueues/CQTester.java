public class CQTester {
    public static void main(String[] args) {
        CirQueue q = new CirQueue(4);

        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();
        q.display(); 

        q.grow(10);

    }
}