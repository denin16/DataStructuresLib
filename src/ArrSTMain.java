public class ArrSTMain {
    /*
    Functions defined for the ArrST (stack implementation using arrays) (Default size of stack is 10)
    - size() - Returns the size of the list
    - isEmpty() - Returns true if it is empty, else false
    - peek() - Returns the data stored on the top of the stack
    - push() - Add data into the stack is capacity isn't reached
    - pop() - Pops the top most element of the stack and returns it back
    */
    public static void main(String[] args) {
        ArrST<Integer> ast = new ArrST<>();

        System.out.println("Size of the Stack is :" + ast.size());

        ast.push(21);
        ast.push(12);
        ast.push(31);

        System.out.println("Stack : " + ast);
        System.out.println("Size of the Stack is :" + ast.size());

        ast.push(1);
        ast.push(53);
        ast.push(42);
        ast.push(26);
        ast.push(74);
        ast.push(56);
        ast.push(44);

        System.out.println("Stack : " + ast);
        System.out.println("Size of the Stack is :" + ast.size());

        //ast.push(11);

        System.out.println("Is the stack empty? : " + ast.isEmpty());

        System.out.println("Element poped out of the stack : " + ast.pop());
        System.out.println("Element poped out of the stack : " + ast.pop());
        System.out.println("Stack : " + ast);
        System.out.println("Size of the Stack is :" + ast.size());

        System.out.println("Top element of the stack is : " + ast.peek());
    }
}
