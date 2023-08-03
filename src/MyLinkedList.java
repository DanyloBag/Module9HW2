
public class MyLinkedList <N>{

    private class Node<N>{
        private Node<N> prevNode;
        private Node<N> nextNode;
        private N value;

        public Node(Node<N> prevNode, Node<N> nextNode, N value) {
            this.prevNode = prevNode;
            this.nextNode = nextNode;
            this.value = value;
        }

        public Node<N> getPrevNode() {
            return prevNode;
        }

        public void setPrevNode(Node<N> prevNode) {
            this.prevNode = prevNode;
        }

        public Node<N> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<N> nextNode) {
            this.nextNode = nextNode;
        }

        public N getValue() {
            return value;
        }

        public void setValue(N value) {
            this.value = value;
        }
    }

    private Node<N> firstNode;
    private Node<N> lastNode;
    private int size=0;


    public void add(N value){
        if(firstNode == null){
            firstNode = new Node<>(null, null, value);
        }
        else if(lastNode == null){
            lastNode = new Node<>(firstNode,null,value);
            firstNode.setNextNode(lastNode);
        } else {
            Node<N> node = new Node<>(lastNode, null, value);
            lastNode.setNextNode(node);
            lastNode = node;
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }

        Node<N> nodeToRemove = getNodeAtIndex(index);
        Node<N> prevNode = nodeToRemove.prevNode;
        Node<N> nextNode = nodeToRemove.nextNode;

        if(prevNode != null){
            prevNode.nextNode = nextNode;
        } else {
            firstNode = nextNode;
        }
        if(nextNode != null){
            nextNode.prevNode = prevNode;
        } else {
            lastNode = prevNode;
        }
        size--;
    }

    public int size(){
        return size;
    }

    public void clear(){
        firstNode = null;
        lastNode = null;
        size = 0;
    }
    public N get(int index){
        Node<N> currentNode = firstNode;
        checkIndex(index);
        if(index == 0){
            return currentNode.getValue();
        }
        for (int i = 0; i < index; i++){
            currentNode = currentNode.getNextNode();
        }
        return currentNode.getValue();
    }

    private Node<N> getNodeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        Node<N> currentNode;
        currentNode=firstNode;
        for (int i = 0; i < index; i++){
            currentNode = currentNode.getNextNode();
        }

        return currentNode;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
    }
}
