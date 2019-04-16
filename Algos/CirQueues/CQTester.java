public class CQTester {
    public static void main(String[] args) {
        CirQueue q = new CirQueue(4);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.dequeue();
        q.dequeue();
        q.enqueue(5);
        q.enqueue(6);
        System.out.println(q.Front());
    }
}