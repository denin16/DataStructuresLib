import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PQU<T extends Comparable<T>> {
    private int heapSize = 0;
    private int heapCapacity = 0;

    private List<T> heap = null;

    public PQU(){
        this(1);
    }

    public PQU(int size){
        heap = new ArrayList<>(size);
    }

    public PQU(T[] elems){
        heapSize = heapCapacity = elems.length;
        heap = new ArrayList<>(heapCapacity);

        for(int i=0; i < heapCapacity; i++){
            heap.add(elems[i]);
        }

        for(int i= Math.max(0, (heapSize/2)-1); i >= 0; i--){
            sink(i);
        }
    }

    public PQU(Collection<T> elems){
        this(elems.size());
        for (T elem: elems) add(elem);
    }

    //To returns the size of queue
    public int size(){
        return heapSize;
    }

    //To check is the queue is empty or not
    public boolean isEmpty(){
        return size() == 0;
    }

    //To empty the queue
    public void clear(){
        for(int i=0; i < heapSize; i++){
            heap.set(i, null);
        }
        heapSize = 0;
    }

    //To get the first element of the queue
    public T peek(){
        return heap.get(0);
    }

    //To remove the first element of the queue
    public T poll(){
        return removeAt(0);
    }

    //To check if the Queue contains the given element or not
    public boolean contains(T elem){
        for(int i=0; i < heapSize; i++){
            if(elem.equals(heap.get(i))) return true;
        }
        return false;
    }

    //To add an element to the queue
    public void add(T elem){
        if(elem == null) throw new IllegalArgumentException();

        if(heapSize < heapCapacity){ //Heap has space already
            heap.set(heapSize, elem);
        } else {
            heap.add(elem);
            heapCapacity++;
        }
        swim(heapSize);
        heapSize++;
    }

    //Private method to check if the item on first index is less than item on second index
    private boolean less(int i, int j){
        T elem1 = heap.get(i);
        T elem2 = heap.get(j);

        if(elem1.compareTo(elem2) <= 0) return true;
        return false;
    }

    //To swap elements b/w the two indexes
    private void swap(int i, int j){
        T elem1 = heap.get(i);
        T elem2 = heap.get(j);

        heap.set(i, elem2);
        heap.set(j, elem1);
    }

    //To bubble up if the parent of current node is less than current item value
    public void swim(int k){
        int parent = (k-1)/2;

        while (k > 0 && less(k,parent)){
            swap(k, parent);
            k = parent;
            parent = (k-1)/2;
        }
    }

    //To bubble down if the value of the child nodes is less than the value of current node
    public void sink(int k){
        while (true){
            int left = 2 * k + 1;
            int right = 2 * k + 2;
            int smallest = left;

            if(heapSize > right && less(right, left)) smallest = right;

            if(heapSize <= left || less(k, smallest)) break;

            swap(k, smallest);
            k = smallest;
        }
    }

    //To remove a given element if present
    public boolean remove(T element){
        if (element == null) return false;
        // Linear removal via search, O(n)
        for (int i = 0; i < heapSize; i++) {
            if (element.equals(heap.get(i))) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    //Private method to remove at a given index
    private T removeAt(int i){

        heapSize--;
        T removeData = heap.get(i);
        swap(i, heapSize);

        heap.set(heapSize, null);

        if(i == heapSize) return removeData;

        T elem = heap.get(i);

        swim(i);

        //To if it swimmed up or not, else sink down
        if(heap.get(i).equals(elem)) sink(i);
        return removeData;
    }

    //To print all the elements of the queue
    @Override
    public String toString(){
        return heap.toString();
    }

}
