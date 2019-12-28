public class DLL<T> implements Iterable<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size;

    //Defining Node class to store the data and pointers to previous and next node
    public class Node<T>{
        private T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T data, Node<T> prev, Node<T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    //To get the size of the List
    public int size(){
        return size;
    }

    //To check if the list is empty or not
    public boolean isEmpty(){
        return size() == 0;
    }

    //To add a data node before the header
    public boolean addFirst(T data){
        if(data == null) return false;

        //Checking if List is empty
        if(isEmpty()){
            Node<T> newNode = new Node<>(data,null,null);
            head = tail = newNode;
            size++;
            return true;
        } else { //List isnt empty
            Node<T> newNode = new Node<>(data, null, null);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
            return true;
        }
    }

    //To add a data node after the tail of the list
    public boolean addLast(T data){
        if(data == null) return false;

        if(isEmpty()){//List is empty
            Node<T> newNode = new Node<>(data, null, null);
            head = tail = newNode;
            size++;
            return true;
        } else {//List is not empty
            Node<T> newNode = new Node<>(data, null, null);
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            size++;
            return true;
        }
    }

    //To add data node to the list
    public boolean add(T data){
        return addLast(data);
    }

    //To add a data node at a given index
    public boolean addAt(T data, int index){
        if(index > size || index < 0) throw new RuntimeException("Illegal Index");
        else if(index == 0) addFirst(data);
        else if(index == size) addLast(data);
        else {
            Node<T> trav = head;
            int counter = 0;

            while (counter != index-1){
                trav = trav.next;
                counter++;
            }

            Node<T> newNode = new Node<>(data, null, null);
            newNode.prev = trav;
            newNode.next =  trav.next;
            trav.next.prev = newNode;
            trav.next = newNode;
            size++;
        }
        return true;
    }

    //To empty the list
    public void clear(){
        if(isEmpty()) return;
        Node<T> trav1 = head;
        Node<T> trav2 = head.next;
        while (trav2 != null){
            trav1.data = null;
            trav1.next = trav1.prev = null;
            trav2.prev = null;
            trav1 = trav2;
            trav2=trav1.next;
        }
        head = tail = trav1 = trav2 = null;
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
        if(isEmpty()) throw new RuntimeException("Empty List!");

        Node<T> first = head;
        head = head.next;
        T data = first.data;
        first.data = null;
        first.prev = first.next = first = null;
        --size;

        if(isEmpty()) tail = null;
        else head.prev = null;

        return data;
    }

    //To remove the last element of the list
    public T removeLast(){
        if(isEmpty()) throw new RuntimeException("Empty List");

        Node<T> last = tail;
        tail = tail.prev;
        T data = last.data;
        last.data = null;
        last.prev = last.next = null;
        --size;

        if(isEmpty()) head = null;
        else tail.next = null;

        return data;
    }

    //Private method to remove a node
    private T removeNode(Node<T> node){
        if(node ==  head) return removeFirst();
        else if(node == tail) return removeLast();
        else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
            T data = node.data;
            node.prev = node.next = null;
            node.data = null;
            size--;
            return data;
        }
    }

    //To remove a node from a given index
    public T removeAt(int index){
        if(index > size || index < 0) throw new RuntimeException("Illegal Index");
        int counter = 0;
        Node<T> trav = head;
        while (counter < index){
            trav = trav.next;
            counter++;
        }
        return removeNode(trav);
    }

    //To remove a given value from the list
    public void remove(T value){
        Node<T> trav = head;
        while (trav.data != value){
            trav = trav.next;
        }
        removeNode(trav);
    }

    //To get the index of a value
    public int indexOf(T value){
        int counter = 0;
        Node<T> trav = head;
        while (trav.data != value){
            if(trav.next == null)
                throw new IndexOutOfBoundsException("Element not present");

            trav = trav.next;
            counter++;
        }
        return counter ;
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
            public void remove(){ throw new UnsupportedOperationException();}
        };
    }

    @Override
    public String toString(){
        Node<T> trav = head;
        String str = "";
        while (trav != null){
            str += trav.data + " ";
            trav = trav.next;
        }
        return str;
    }
}
