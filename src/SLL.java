public class SLL<T> implements Iterable<T> {
    private int size = 0; //Size of the linked list
    private Node<T> head = null; //Head of the linked list
    private Node<T> tail = null; //Tail of the linked list

    public class Node<T>{
        private Node<T> next;
        private T data;

        public Node(Node<T> next, T data){
            this.next = next;
            this.data =data;
        }
    }

    //To get the size of the linked list
    public int size(){
        return size;
    }

    //To check if the list is empty or not
    public boolean isEmpty(){
        return size() == 0;
    }

    //To add element before the header
    public boolean addFirst(T data){
        if(isEmpty()){
            Node<T> newNode = new Node<>(null, data);
            head = tail = newNode;
            size++;
            return true;
        } else {
            Node<T> newNode = new Node<>(null, data);
            newNode.next = head;
            head = newNode;
            size++;
            return true;
        }
    }

    //To add element after the tail
    public boolean addLast(T data){
        if(isEmpty()){
            Node<T> newNode = new Node<>(null, data);
            head =  tail = newNode;
            size++;
            return true;
        } else {
            Node<T> newNode = new Node<>(null, data);
            tail.next = newNode;
            tail = newNode;
            size++;
            return true;
        }
    }

    //To add data to the linked list
    public boolean add(T data){
        return addLast(data);
    }

    //To add an element at a specific index
    public boolean addAt(T data, int index){
        if(index > size || index < 0) throw new RuntimeException("Illegal Index");
        else if(index == 0) addFirst(data);
        else if(index == size) addLast(data);
        else {
            Node<T> trav = head;
            int counter = 0;

            while (counter < index - 1){
                trav = trav.next;
                counter++;
            }

            Node<T> newNode = new Node<>(null, data);
            newNode.next = trav.next;
            trav.next = newNode;
            size++;
        }
        return true;
    }

    //To empty the list
    public void clear(){
        Node<T> trav = head.next;
        while (trav != null){
            head.next = null;
            head.data = null;
            head = trav;
            trav = head.next;
        }
        head = tail = trav = null;
        size = 0;
    }

    //To get the first element of the list
    public T peekFirst(){
        if(isEmpty()) throw new RuntimeException("List empty!");
        return head.data;
    }

    //To get the last element of the list
    public T peekLast(){
        if(isEmpty()) throw new RuntimeException("List empty!");
        return tail.data;
    }

    //To remove the first element of the list
    public T removeFirst(){
        if(isEmpty()) throw new RuntimeException("List empty!");

        Node<T> firstNode = head;
        head = head.next;
        T data = firstNode.data;
        firstNode.data = null;
        firstNode.next = null;
        size--;
        return data;
    }

    //To remove the last element of the list
    public T removeLast(){
        if(isEmpty()) throw new RuntimeException("List empty!");
        else if(head == tail){
            T data = head.data;
            head = tail = null;
            return data;
        }
        Node<T> trav = head;
        while (trav.next != tail){
            trav = trav.next;
        }
        T data = tail.data;
        tail.data = null;
        trav.next = null;
        tail = trav;
        size--;
        return data;
    }

    //To remove an element at a specific index
    public T removeAt(int index){
        if(index > size || index < 0) throw new RuntimeException("Illegal Index");
        else if(index == 0 ) return removeFirst();
        else if(index == size) return removeLast();
        else {
            int counter = 0;
            Node<T> trav = head;

            while (counter < index-1){
                trav = trav.next;
                counter++;
            }

            Node<T> nodeToRemove = trav.next;
            trav.next = trav.next.next;
            T data = nodeToRemove.data;
            nodeToRemove.next = null;
            size--;
            return data;
        }
    }

    //To remove a specific element from the list
    public T remove(T value){
        Node<T> trav = head;
        int index = 0;
        while (trav.data != value){
            if(trav.next == null) throw new RuntimeException("Element not present in list");
            trav = trav.next;
            index++;
        }
        return removeAt(index);
    }

    //To get the index of an element if present
    public int indexOf(T value){
        Node<T> trav = head;
        int index = 0;
        while (trav.data != value){
            if(trav.next == null) throw new RuntimeException("Element not present in list");
            trav = trav.next;
            index++;
        }
        return index;
    }

    //To get all the elements of the list
    @Override
    public String toString(){
        Node<T> trav = head;
        StringBuilder str = new StringBuilder();
        str.append("[");
        while (trav != null){
            str.append(" " + trav.data);
            trav = trav.next;
        }
        str.append(" ]");
        return str.toString();
    }

    @Override
    public java.util.Iterator<T> iterator(){
        return new java.util.Iterator<>(){
            private Node<T> trav = head;

            @Override
            public boolean hasNext(){
                return trav != null;
            }

            @Override
            public T next(){
                T data = trav.data;
                trav = trav.next;
                return data;
            }

            @Override
            public void remove(){ throw new UnsupportedOperationException(); }
        };
    }
}