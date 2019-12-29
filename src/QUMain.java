public class QUMain {
    /*
    Functions defined for the QU class
    - size() - Returns the size of the queue
    - isEmpty() - Returns true if it is empty, else false
    - peek() - Returns the data stored in the front of queue
    - offer() - Adds data into the queue
    - poll() - Removes data from the front of the queue and returns it back
    - clear() - Empties the queue
    */
    public static void main(String[] args) {
        QU<Integer> q = new QU<>();

        System.out.println("Is the Queue Empty? : " + q.isEmpty());

        q.offer(21);
        q.offer(36);
        q.offer(24);
        q.offer(90);
        q.offer(37);

        System.out.println("Queue : " + q);

        q.poll();
        System.out.println("Queue : " + q);

        //q.clear();
        //System.out.println("Queue : " + q);

        //q.poll();

        System.out.println("Element in the front : " + q.peek());
    }
}
