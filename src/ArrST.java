import java.util.ArrayList;

public class ArrST<T> {

    int maxSize = 10;
    ArrayList<T> arrst = new ArrayList<>();

    //To get the size of the stack
    public int size(){
        return arrst.size();
    }

    //To check is the stack is empty or not
    public boolean isEmpty(){
        return size() == 0;
    }

    //To push an element into the stack
    public void push(T data){
        if(size() == maxSize) throw new RuntimeException("Stack is full");
        arrst.add(data);
    }

    //To pop an element of the stack
    public T pop(){
        if(isEmpty()) throw new RuntimeException("Stack is Empty!");
        else {
            T data = arrst.remove(size()-1);
            return data;
        }
    }

    //To get the top most element of the stack
    public T peek(){
        if(isEmpty()) throw new RuntimeException("Stack is Empty!");
        else{
            T data = arrst.get(size()-1);
            return data;
        }
    }

    //To get all the elements of the stack
    public String toString(){
        if(isEmpty()) return "[ ]";
        else{
            StringBuilder str = new StringBuilder();
            str.append("[");
            for(int i=0; i < size(); i++){
                str.append(" " + arrst.get(i));
            }
            str.append(" ]");
            return str.toString();
        }
    }
}
