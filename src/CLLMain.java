public class CLLMain {
    /*
    Functions defined for the CLL (Circular Linked List) class
    - size() - Returns the size of the list
    - isEmpty() - Returns true if it is empty, else false
    - peekFirst() - Returns the data stored in first node
    - peekLast() - Returns the data stored in last node
    - addFirst(data) - Adds data node before the header
    - addLast(data) - Adds data node after the tail
    - clear() - Empty the list
    - remove() - Removes the last element from the list and returns it back
    - remove(value) - Remove a value from the list if it present if it present
    */

    public static void main(String[] args) {
        CLL<Integer> cll = new CLL<>();

        System.out.println("Size of the Circular list is: " + cll.size());

        cll.addFirst(23);
        cll.addFirst(61);
        cll.addFirst(20);
        cll.addFirst(6);
        cll.addLast(26);
        System.out.println("List : " + cll);

        //cll.clear();
        System.out.println(cll);
        System.out.println(cll.remove());
        System.out.println(cll.remove());
        System.out.println(cll);

        cll.remove(61);
        //cll.remove(20);
        //cll.remove(6);
        //cll.remove(54);
        System.out.println(cll);

        System.out.println(cll.peekFirst());
        System.out.println(cll.peekLast());
    }
}
