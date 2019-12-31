public class PQUMain {
    /*
    Functions defined for PQU class
    - size() - Returns the size of the Priority Queue
    - isEmpty() - Returns true if Priority Queue is empty, else false
    - clear() - Empties the queue
    - peek() - Returns the front element of the Queue
    - poll() - Removes and returns the front element element of the Queue
    - contains(elem) - Returns true if elem is in queue, else false
    - add(elem) - Adds elem to the queue
    - remove(elem) - Removes elem from the queue
    */
    public static void main(String[] args) {
        PQU<Integer> bhr = new PQU<>();

        System.out.println("Is the lift empty? : " + bhr.isEmpty());

        bhr.add(1);
        bhr.add(5);
        bhr.add(10);
        bhr.add(12);
        bhr.add(13);
        bhr.add(16);
        bhr.add(2);

        System.out.println(bhr);

        //bhr.clear();

        bhr.poll();
        bhr.poll();

        bhr.remove(13);
        System.out.println(bhr.toString());

        System.out.println("Contains 12? : " + bhr.contains(12));

        System.out.println("Element in front of the Priority Queue: " + bhr.peek());
        System.out.println("Size of heap is : " + bhr.size());
    }
}
