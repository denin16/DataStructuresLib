public class STMain {
    /*
    Functions defined for the ST (Stack) class
    - size() - Returns the size of the stack
    - isEmpty() - Returns true if stack is empty else returns false
    - push(data) - Pushes data into the stack
    - pop() - Returns the top element from the stack and removes it from it.
    - peek() - Returns the top element of the stack
    */
    public static void main(String[] args) {
        ST<Integer> st = new ST<>();
        System.out.println("Is the stack empty? : " + st.isEmpty());

        st.push(10);
        st.push(23);
        st.push(31);
        System.out.println("Stack : " + st);

        System.out.println("Element poped out of the stack : " + st.pop());
        System.out.println("The top element in the stack is now : " + st.peek());
        System.out.println("Stack : " + st);
        System.out.println("Size of the stack is: " + st.size());
    }
}
