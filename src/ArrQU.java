import java.util.ArrayList;

public class ArrQU<T> {

    int maxSize = 5;
    ArrayList<T> aqu = new ArrayList<>();

    //To get the size of the queue
    public int size(){
        return aqu.size();
    }

    //To check is the queue is empty
    public boolean isEmpty(){
        return aqu.isEmpty();
    }

    //To add data into the queue
    public void offer(T data){
        aqu.add(data);
    }

    //To remove data from the queue
    public T poll(){
        if(isEmpty()) throw new RuntimeException("Queue is Empty!");
        T data = aqu.get(0);
        leftShift(aqu);
        return data;
    }

    //Private method to shift the array to the left
    private void leftShift(ArrayList<T> aqu){
        for(int i=0; i < size()-1; i++){
            aqu.set(i,aqu.get(i+1));
        }
        aqu.remove(size()-1);
    }

    public void clear(){
        for(int i=size()-1; i >= 0; i--){
            aqu.remove(i);
        }
    }

    //To get the element in the front of queue
    public T peek(){
        return aqu.get(0);
    }

    //To get all the elements of the queue
    public String toString(){
        if(isEmpty()) return "[ ]";
        else{
            StringBuilder str = new StringBuilder();
            str.append("[");
            for(int i=0; i < size(); i++){
                str.append(" " + aqu.get(i));
            }
            str.append(" ]");
            return str.toString();
        }
    }
}
