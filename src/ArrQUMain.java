public class ArrQUMain {
    /*
    Functions defined for the ArrQU class
    - size() - Returns the size of the queue
    - isEmpty() - Returns true if it is empty, else false
    - peek() - Returns the data stored in the front of queue
    - offer() - Adds data into the queue
    - poll() - Removes data from the front of the queue and returns it back
    - clear() - Empties the queue
    */
    public static void main(String[] args) {
        ArrQU<Integer> aq = new ArrQU<>();

        System.out.println("Is the Queue Empty? : " + aq.isEmpty());

        aq.offer(21);
        aq.offer(36);
        aq.offer(24);
        aq.offer(90);
        aq.offer(37);

        System.out.println("Queue : " + aq);

        aq.poll();
        System.out.println("Queue : " + aq);

        System.out.println("Size of Queue: " + aq.size());

        //aq.clear();
        //System.out.println("Queue : " + aq);

        //aq.poll()

        System.out.println("Element in the front : " + aq.peek());
    }
}
