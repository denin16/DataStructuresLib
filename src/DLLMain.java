public class DLLMain {
    /*
    Functions defined for the DLL (Doubly Linked List) class
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
        DLL<Integer> dll = new DLL<>();

        System.out.println("Size of the List is : " + dll.size());

        dll.add(21);
        dll.add(24);
        dll.add(36);

        System.out.println("List : " + dll.toString());
        System.out.println("Size of the List is : " + dll.size());

        dll.addFirst(98);
        dll.addLast(8);

        System.out.println("List : " + dll.toString());

        System.out.println("First element: " + dll.peekFirst());
        System.out.println("Last element: " + dll.peekLast());

        System.out.println("Is the List Empty? : " + dll.isEmpty());

        dll.addAt(30,2);
        System.out.println("List : " + dll.toString());
        System.out.println("Size of the List is : " + dll.size());

        //dll.clear();
        //System.out.println("List : " + dll.toString());
        //System.out.println("Size of the List is : " + dll.size());

        dll.removeFirst();
        dll.removeLast();
        System.out.println("List : " + dll.toString());
        System.out.println("Size of the List is : " + dll.size());

        dll.removeAt(3);
        System.out.println("List : " + dll.toString());
        System.out.println("Size of the List is : " + dll.size());

        dll.remove(30);
        System.out.println("List : " + dll.toString());
        System.out.println("Size of the List is : " + dll.size());

        dll.add(43);
        dll.add(53);
        System.out.println("Index of 21 is : " + dll.indexOf(53));
        System.out.println("List : " + dll.toString());
        System.out.println("Size of the List is : " + dll.size());

    }
}
