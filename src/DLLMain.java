public class DLLMain {
    public static void main(String[] args) {
        DLL<Integer> list = new DLL<>();
        list.add(23);
        list.add(56);
        list.add(52);
        list.add(33);
        list.addFirst(24);
        //list.clear();
        list.addAt(60, 2);
        list.removeAt(2);
        list.remove(52);
        System.out.println(list.indexOf(57));
        System.out.println(list.toString());
        System.out.println("Size of the list is : " + list.size());
        System.out.println("Is the list empty? " + list.isEmpty());
    }
}
