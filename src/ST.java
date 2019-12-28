public class ST<T> {
    /* Implementation of Stack Using Doubly Linked List */

    DLL<T> dll = new DLL<>();

    //To get the size of the stack
    public int size(){
        return dll.size();
    }

    //To check if the stack is empty or not
    public boolean isEmpty(){
        return dll.isEmpty();
    }

    //To push data into the stack
    public boolean push(T data){
        return dll.addLast(data);
    }

    //To pop data from the stack
    public T pop(){
        return dll.removeLast();
    }

    //To get the top element of the stack
    public T peek(){
        return dll.peekLast();
    }

    //To get the elements of the stack
    public String toString(){
        return dll.toString();
    }

}
