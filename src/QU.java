public class QU<T> {
    /* Implementation of Queue using Doubly Linked List */

    DLL<T> dll = new DLL<>();

    //To get the size of the Queue
    public int size(){
        return dll.size();
    }

    //To check if the Queue is empty or not
    public boolean isEmpty(){
        return size() == 0;
    }

    //To add element to the queue
    public boolean offer(T data){
        return dll.addLast(data);
    }

    //To remove element from the Queue
    public T poll(){
        return dll.removeFirst();
    }

    //To clear the queue
    public void clear(){
        dll.clear();
    }

    //To get the first element of the queue
    public T peek(){
        return dll.peekFirst();
    }

    //To get all the elements of the queue
    public String toString(){
        return dll.toString();
    }
}
