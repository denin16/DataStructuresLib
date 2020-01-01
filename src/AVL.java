public class AVL<T extends Comparable<T>> {
    private int nodeCount = 0;
    private Node root = null;

    private class Node{
        int bf; //Balance factor of its subtree
        int height; //Height of the node
        T data;
        Node left;
        Node right;

        public Node(Node left, Node right, T data){
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }

    public int size(){
        return nodeCount;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int height(){
        if(root == null) return 0;
        return root.height;
    }

    public boolean contains(T elem){
        return contains(root, elem);
    }

    private boolean contains(Node node, T elem){
        //Checking for the base condition : Reached null node, node not found
        if(node == null) return false;

        //else
        int cmp = elem.compareTo(node.data);

        //Check if the data is smaller than current node
        if(cmp < 0) return contains(node.left, elem);

            //Check if the data is bigger than current node
        else if(cmp > 0) return contains(node.right, elem);

            //Value found in the tree
        else return true;
    }

    public boolean insert(T elem){
        if(elem == null) return false;
        if(contains(elem)){
            return false;
        } else {
            root = insert(root, elem);
            nodeCount++;
            return true;
        }
    }

    public Node insert(Node node, T elem){
        if(node == null) return new Node(null, null, elem);

        //else
        int cmp = elem.compareTo(node.data);

        if(cmp < 0){
            node.left = insert(node.left, elem);
        } else {
            node.right = insert(node.right, elem);
        }

        update(node);
        return balance(node);
    }

    public void update(Node node){
        int leftNodeHeight = (node.left == null) ? -1 : node.left.height;
        int rightNodeHeight = (node.right == null) ? -1 : node.right.height;

        node.height = 1 + Math.max(leftNodeHeight, rightNodeHeight);

        node.bf = rightNodeHeight - leftNodeHeight;
    }

    public Node balance(Node node){
        if(node.bf == -2){ //left heavy case
            if(node.left.bf <= 0){ //left left case
                return leftLeftCase(node);
            } else { //left right case
                return leftRightCase(node);
            }
        } else if(node.bf == 2){ //right heavy case
            if(node.right.bf >= 0){ //right right case
                return rightRightCase(node);
            } else {
                return rightLeftCase(node);
            }
        } else return node;
    }

    public Node leftLeftCase(Node node){
        return rightRotation(node);
    }

    public Node leftRightCase(Node node){
        node.left = leftRotation(node.left);
        return rightRotation(node);
    }

    public Node rightRightCase(Node node){
        return leftRotation(node);
    }

    public Node rightLeftCase(Node node){
        node.right = rightRotation(node.right);
        return leftRotation(node);
    }

    public Node rightRotation(Node node){
        Node newParentNode = node.left;
        node.left = newParentNode.right;
        newParentNode.right = node;
        update(node);
        update(newParentNode);
        return newParentNode;
    }

    public Node leftRotation(Node node){
        Node newParentNode = node.right;
        node.right = newParentNode.left;
        newParentNode.left = node;
        update(node);
        update(newParentNode);
        return newParentNode;
    }

    public Node findMin(Node node){
        while (node.left != null) node = node.left;
        return node;
    }

    public Node findMax(Node node){
        while (node.right != null) node = node.right;
        return node;
    }

    public boolean remove(T elem){
        if(contains(elem)){
            root = remove(root, elem);
            nodeCount--;
            return true;
        } else {
            return false;
        }
    }

    public Node remove(Node node, T elem){
        if(node == null) return null;

        //else
        int cmp = elem.compareTo(node.data);

        if(cmp < 0){
            node.left = remove(node.left, elem);
        } else if(cmp > 0){
            node.right = remove(node.right, elem);
        } else {
            if(node.right == null){
                Node leftChild = node.left;
                node.data = null;
                node = null;
                return leftChild;
            } else if(node.left == null){
                Node rightChild = node.right;
                node.data = null;
                node = null;
                return rightChild;
            } else {
                if(node.left.height > node.right.height){
                    Node tmp = findMax(node.left);
                    node.data = tmp.data;
                    node.left = remove(node.left, tmp.data);
                } else {
                    Node tmp = findMin(node.right);
                    node.data = tmp.data;
                    node.right = remove(node.right, tmp.data);
                }
            }
        }
        update(node);
        return balance(node);
    }

    public java.util.Iterator<T> traverse(TreeTraversalOrder order){
        switch (order){
            case PRE_ORDER:
                return preOrderTraversal();
            case IN_ORDER:
                return inOrderTraversal();
            case POST_ORDER:
                return postOrderTraversal();
            case LEVEL_ORDER:
                return levelOrderTraversal();
            default:
                return null;
        }
    }

    private java.util.Iterator<T> preOrderTraversal(){
        final int expectedNodeCount = nodeCount;
        final java.util.Stack<AVL.Node> stack = new java.util.Stack<>();
        stack.push(root);

        return new java.util.Iterator<T>(){
            @Override
            public boolean hasNext(){
                if(expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
                return root != null && !(stack.isEmpty());
            }

            @Override
            public T next(){
                if(expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
                AVL.Node node = stack.pop();
                if(node.right != null) stack.push(node.right);
                if(node.left !=  null) stack.push(node.left);
                return (T) node.data;
            }

            @Override
            public void remove(){ throw new UnsupportedOperationException(); }
        };
    }

    private java.util.Iterator<T> inOrderTraversal(){
        final int expectedNodeCount = nodeCount;
        final java.util.Stack<AVL.Node> stack = new java.util.Stack<>();
        stack.push(root);

        return new java.util.Iterator<T>(){
            AVL.Node trav = root;

            @Override
            public boolean hasNext(){
                if(expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
                return root != null && !(stack.isEmpty());
            }

            @Override
            public T next(){
                if(expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();

                while (trav != null && trav.left != null){
                    stack.push(trav.left);
                    trav = trav.left;
                }

                AVL.Node node = stack.pop();

                if(node.right != null){
                    stack.push(node.right);
                    trav = node.right;
                }

                return (T) node.data;
            }

            @Override
            public void remove(){ throw new UnsupportedOperationException(); }
        };
    }

    private java.util.Iterator<T> postOrderTraversal(){
        final int expectedNodeCount = nodeCount;
        final java.util.Stack<AVL.Node> stack1 = new java.util.Stack<>();
        final java.util.Stack<AVL.Node> stack2 = new java.util.Stack<>();
        stack1.push(root);

        while (!(stack1.isEmpty())){
            AVL.Node node = stack1.pop();
            if(node != null){
                stack2.push(node);
                if(node.left != null) stack1.push(node.left);
                if(node.right != null) stack1.push(node.right);
            }
        }

        return new java.util.Iterator<T>(){
            @Override
            public boolean hasNext(){
                if(expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
                return root != null && !(stack2.isEmpty());
            }

            @Override
            public T next(){
                if(expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
                return (T) stack2.pop().data;
            }

            @Override
            public void remove(){ throw new UnsupportedOperationException(); }
        };
    }

    private java.util.Iterator<T> levelOrderTraversal(){
        final int expectedNodeCount = nodeCount;
        final java.util.Queue<AVL.Node> queue = new java.util.LinkedList<>();
        queue.offer(root);

        return new java.util.Iterator<T>(){
            @Override
            public boolean hasNext(){
                if(expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
                return root != null && !(queue.isEmpty());
            }

            @Override
            public T next(){
                if(expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
                AVL.Node node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                return (T) node.data;
            }

            @Override
            public void remove(){ throw new UnsupportedOperationException(); }
        };
    }
}
