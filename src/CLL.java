public class CLL<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> start = null;

    //Defining the structure of the node to be stored in list
    public class Node<T>{
        private T data;
        private Node<T> next;

        public Node(Node<T> next, T data){
            this.data = data;
            this.next = next;
        }
    }

    //To get the size of the list
    public int size(){
        return size;
    }

    //To check if the list is empty or not
    public boolean isEmpty(){
        return size() == 0;
    }

    //To add before the start header
    public boolean addFirst(T data){
        if(isEmpty()){ //List empty
            Node<T> newNode = new Node<>(null, data);
            newNode.next = newNode;
            start = newNode;
            size++;
            return true;
        } else {
            Node<T> newNode = new Node<>(null, data);
            Node<T> end = start;

            while (end.next != start){
                end = end.next;
            }

            end.next = newNode;
            newNode.next = start;
            start = newNode;
            size++;
            return true;
        }
    }

    //To add at the end of the list
    public boolean addLast(T data){
        if(isEmpty()){ //List empty
            Node<T> newNode = new Node<>(null, data);
            newNode.next = newNode;
            start = newNode;
            size++;
            return true;
        } else {
            Node<T> newNode = new Node<>(null, data);
            Node<T> end = start;

            while (end.next != start){
                end = end.next;
            }

            end.next = newNode;
            newNode.next = start;
            size++;
            return true;
        }
    }

    //To empty the list
    public void clear(){
        if(isEmpty()) throw new RuntimeException("Empty List!");
        else if(size() == 1){
            start.data = null;
            start.next = null;
            start = null;
        } else {
            Node<T> trav1 = start;
            Node<T> trav2 = start.next;
            while (trav2 != start){
                trav1.next = null;
                trav1.data = null;
                trav1 = trav2;
                trav2 = trav2.next;
            }
            size = 0;
        }
    }

    //To remove from the end of the list
    public T remove(){
        if(isEmpty()) throw new RuntimeException("Empty List");
        else if(size() == 1){
            T data = start.data;
            start.data = null;
            start.next = null;
            start = null;
            size--;
            return data;
        } else {
            Node<T> trav = start;
            while (trav.next.next != start){
                trav = trav.next;
            }
            Node<T> nodeToRemove = trav.next;
            T data = nodeToRemove.data;
            nodeToRemove.next = null;
            nodeToRemove.data = null;
            trav.next = start;
            nodeToRemove = null;
            size--;
            return data;
        }
    }

    //To remove a value from the list if present
    public boolean remove(T value){
        if(isEmpty()) throw new RuntimeException("List Empty!");
        else {
            Node<T> trav = start;
            int counter = 0;
            while (trav.next.data != value){
                if(counter >= size) throw new RuntimeException("Element not in the list");
                trav = trav.next;
                counter++;
            }
            Node<T> nodeToRemove = trav.next;
            if(nodeToRemove == start) start = nodeToRemove.next;
            trav.next = nodeToRemove.next;
            nodeToRemove.next = null;
            nodeToRemove.data = null;
            size--;
            return true;
        }
    }

    //To get the first element of the list
    public T peekFirst(){
        if(isEmpty()) throw new RuntimeException("List empty!");
        return start.data;
    }

    //To get the last element of the list
    public T peekLast(){
        if(isEmpty()) throw new RuntimeException("List empty!");

        Node<T> trav = start;
        while (trav.next != start){
            trav = trav.next;
        }
        return trav.data;
    }

    //To get all the elements of the list
    public String toString(){
        if(isEmpty()) return "[ ]";

        Node<T> trav = start;
        StringBuilder str = new StringBuilder();
        str.append("[");
        if(size >= 1) str.append(" " + start.data);
        while (trav.next != start){
            trav = trav.next;
            if(trav != null)
                str.append(" " + trav.data);
        }
        str.append(" ]");
        return str.toString();
    }
    @Override
    public java.util.Iterator<T> iterator(){
        return new java.util.Iterator<T>() {
            Node<T> trav = start;
            @Override
            public boolean hasNext() {
                return (trav.next != start || trav.next != null);
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }
}
