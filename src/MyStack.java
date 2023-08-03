
public class MyStack<T> {
    private class Node<T>{
        private Node<T> prevNode;
        private Node<T> nextNode;
        private  T value;

        public Node(Node<T> prevNode,Node<T> nextNode,T value) {
            this.nextNode = nextNode;
            this.prevNode = prevNode;
            this.value = value;
        }

        public Node<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }

        public Node<T> getPrevNode() {
            return prevNode;
        }

        public void setPrevNode(Node<T> prevNode) {
            this.prevNode = prevNode;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;


    public void push(T value) {
        if (firstNode == null) {
            firstNode = lastNode = new Node<T>(null, null, value);
            size++;
        } else if (lastNode == null) {
            lastNode = new Node<T>(firstNode, null, value);
            firstNode.setNextNode(lastNode);
            lastNode = firstNode;
            size++;
        } else {
            Node<T> node = new Node<>(firstNode, null, value);
            firstNode.setNextNode(node);
            firstNode = node;
            size++;
        }
    }
    public void remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }

        Node<T> nodeToRemove = getNodeAtIndex(index);
        Node<T> prevNode = nodeToRemove.prevNode;
        Node<T> nextNode = nodeToRemove.nextNode;

        if(prevNode != null){
            prevNode.setNextNode(nextNode);
        }else{
            lastNode = nextNode;
        }
        if(nextNode != null){
            nextNode.setPrevNode(prevNode);
        }else{
            firstNode = prevNode;
        }
        size--;
    }
    public void clear(){
        firstNode = null;
        lastNode = null;
        size = 0;
    }
    public int size(){
        return size;
    }
    public T peek(){
        return firstNode.value;
    }
    public T pop(){
        T popReturn = firstNode.value;
        remove(0);
        return popReturn;
    }
    private Node<T> getNodeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        Node<T> currentNode;
        currentNode=firstNode;
        for (int i = 0; i < index; i++){
            currentNode = currentNode.getPrevNode();
        }

        return currentNode;
    }
}