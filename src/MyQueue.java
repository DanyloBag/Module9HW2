public class MyQueue<N> {
    private final MyLinkedList<N> queue = new MyLinkedList<N>();

    public void add(N value){
        queue.add(value);
    }

    public void clear(){
        queue.clear();
    }

    public int size(){
        return queue.size();
    }

    public N peek(){
        return queue.get(0);
    }

    public N poll(){
        N poll = queue.get(0);
        queue.remove(0);
        return poll;
    }

}