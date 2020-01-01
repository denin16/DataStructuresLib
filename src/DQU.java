public class DQU<T>{
    /* Implementation of Doubly ended queue using Doubly Linked List*/

    DLL<T> dll = new DLL<>();

    //To get the size of the queue
    public int size(){ return dll.size(); }

    //To check if the queue is empty or not
    public boolean isEmpty(){ return dll.isEmpty(); }

    //To add element at the front of queue
    public boolean offerFront(T data){ return dll.addFirst(data); }

    //To add element at the last of the queue
    public boolean offerLast(T data){ return dll.addLast(data); }

    //To remove element from the front of queue
    public T pollFirst(){ return dll.removeFirst(); }

    //To remove element from the last of the queue
    public T pollLast(){ return dll.removeLast(); }

    //To empty the queue
    public void clear(){ dll.clear(); }

    //To get the first element of the queue
    public T peekFirst(){ return dll.peekFirst(); }

    //To get the last element of the queue
    public T peekLast(){ return dll.peekLast(); }
}
