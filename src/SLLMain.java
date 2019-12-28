public class SLLMain {
    /*
    Functions defined for the SLL class
    - size() - Returns the size of the list
    - isEmpty() - Returns true if it is empty, else false
    - peekFirst() - Returns the data stored in first node
    - peekLast() - Returns the data stored in last node
    - addFirst(data) - Adds data node before the header
    - addLast(data) - Adds data node after the tail
    - add(data) - Adds data to the node (by default it adds at the end)
    - addAt(index) - Adds data node at a given index
    - clear() - Empty the list
    - removeFirst() - Removes the first element from the list and returns it back
    - removeLast() - Removes the last element from the list and returns it back
    - removeAt(index) - Removes element at given index and returns it back
    - remove(value) - Remove a value from the list if it present if it present
    - indexOf(value) - Returns the index of an element in the list
    */
    public static void main(String[] args) {
        SLL<Integer> sll = new SLL<>();

        System.out.println("Size of the List is : " + sll.size());

        sll.add(21);
        sll.add(24);
        sll.add(36);

        System.out.println("List : " + sll.toString());

        sll.addFirst(98);
        sll.addLast(8);

        System.out.println("List : " + sll.toString());

        System.out.println("First element: " + sll.peekFirst());
        System.out.println("Last element: " + sll.peekLast());

        System.out.println("Is the List Empty? : " + sll.isEmpty());

        sll.addAt(30,2);
        System.out.println("List : " + sll.toString());
        System.out.println("Size of the List is : " + sll.size());

        //sll.clear();
        //System.out.println("List : " + sll.toString());
        //System.out.println("Size of the List is : " + sll.size());

        sll.removeFirst();
        sll.removeLast();
        System.out.println("List : " + sll.toString());
        System.out.println("Size of the List is : " + sll.size());

        sll.removeAt(4);
        System.out.println("List : " + sll.toString());
        System.out.println("Size of the List is : " + sll.size());

        sll.remove(30);
        System.out.println("List : " + sll.toString());
        System.out.println("Size of the List is : " + sll.size());

        sll.add(43);
        sll.add(53);
        System.out.println("Index of 21 is : " + sll.indexOf(53));
        System.out.println("List : " + sll.toString());
        System.out.println("Size of the List is : " + sll.size());

    }
}
