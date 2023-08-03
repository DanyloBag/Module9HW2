public class Test {

    public static void main(String[] args) {
        testMyArrayList();
        testMyLinkedList();
        testMyQueue();
        testMyStack();
        testMyHashMap();

    }


    public static void testMyArrayList() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();


        for (int i = 0; i < 1000000; i++) {
            myArrayList.add(i);
        }

        System.out.println("myArrayList.get(500000) = " + myArrayList.get(500000));

        myArrayList.remove(200000);
        System.out.println("myArrayList.size() = " + myArrayList.size());

        myArrayList.clear();
        System.out.println("myArrayList.size() after clear() = " + myArrayList.size());
    }

    public static void testMyLinkedList() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        for (int i = 0; i < 1000000; i++) {
            myLinkedList.add(i);
        }

        System.out.println("myLinkedList.get(500000) = " + myLinkedList.get(500000));


        myLinkedList.remove(200000);

        System.out.println("myLinkedList.size() after remove() = " + myLinkedList.size());

        myLinkedList.clear();
        System.out.println("myLinkedList.size() after clear() = " + myLinkedList.size());
    }

    public static void testMyQueue() {
        MyQueue<Integer> myQueue = new MyQueue<>();

        for (int i = 0; i < 1000000; i++) {
            myQueue.add(i);
        }

        System.out.println("myQueue.size() = " + myQueue.size());

        System.out.println("myQueue.peek() = " + myQueue.peek());

        System.out.println("myQueue.poll() = " + myQueue.poll());
    }

    public static void testMyStack() {
        MyStack<Integer> myStack = new MyStack<>();

        for (int i = 0; i < 1000000; i++) {
            myStack.push(i);
        }

        System.out.println("myStack.size() = " + myStack.size());

        System.out.println("myStack.peek() = " + myStack.peek());

        System.out.println("myStack.pop() = " + myStack.pop());

    }

    public static void testMyHashMap() {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();

        for (int i = 0; i < 1000000; i++) {
            myHashMap.put("Key" + i, i);
        }

        System.out.println("myHashMap.size() = " + myHashMap.size());

        System.out.println("myHashMap.get(\"Key500000\") = " + myHashMap.get("Key500000"));

        myHashMap.remove("Key200000");


        System.out.println("myHashMap.size() after remove() = " + myHashMap.size());

        myHashMap.clear();
        System.out.println("myHashMap.size() after clear() = " + myHashMap.size());
    }


}


