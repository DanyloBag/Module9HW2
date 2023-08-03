

public class MyHashMap <K,V>{

    private static class Node<K,V>{
        private K key;
        private V value;
        private Node<K, V> nextNode;

        public Node(K key, V value, Node<K, V> nextNode) {
            this.key = key;
            this.value = value;
            this.nextNode = nextNode;
        }
    }

    private static final int DEFAULT_CAPACITY = 16;
    private Node<K, V>[] table;
    private int size;

    public MyHashMap() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        }

        int hash = hash(key);
        Node<K, V> newNode = new Node<>(key, value, null);

        if (table[hash] == null) {
            table[hash] = newNode;
        } else {
            Node<K, V> currentNode = table[hash];
            Node<K, V> prevNode = null;

            while (currentNode != null) {
                if (currentNode.key == key) {
                    currentNode.value = value;
                    return;
                }

                prevNode = currentNode;
                currentNode = currentNode.nextNode;
            }

            prevNode.nextNode = newNode;
        }

        size++;
    }
    public void remove(Object key){
        if(key == null){
            throw new IllegalArgumentException("Key cannot be null.");
        }

        int hash = hash(key);

        Node<K, V> prevNode = null;
        Node<K, V> currentNode = table[hash];

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                if (prevNode == null) {
                    table[hash] = currentNode.nextNode;
                } else {
                    prevNode.nextNode = currentNode.nextNode;
                }
                size--;
                return;
            }

            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }
    }
    public  void clear(){
        table = new Node[DEFAULT_CAPACITY];
        size=0;
    }

    public int size(){
        return size;
    }
    public V get(K key){
        if(key == null){
            throw new IllegalArgumentException("Key cannot be null.");
        }

        int hash = hash(key);
        checkIndex(hash);
        Node<K, V> currentNode = table[hash];

        while (currentNode != null){
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
            currentNode = currentNode.nextNode;
        }
        return null;

    }

    private int hash(Object key){
        return  Math.abs(key.hashCode()) % table.length;
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
    }

}