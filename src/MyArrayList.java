import java.util.Arrays;

public class MyArrayList <T>{
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] values;

    public MyArrayList() {
        values = new Object[DEFAULT_CAPACITY];
    }

    private int size = 0;

    public void add(T obj){
        rebalance();
        values[size] = obj;
        size++;
    }

    public void rebalance(){
        if(values.length - 1 == size){
            values = Arrays.copyOf(values, values.length + 5);
        }
    }



    public void remove(int index){
       checkIndex(index);
        System.arraycopy(values, index + 1, values, index, size - index - 1);
        size--;
    }

    public int size(){
        return size;
    }

    public void clear(){
        values = new Object[DEFAULT_CAPACITY];
        size=0;

    }

    public T get(int index){
        checkIndex(index);
        return  (T) values[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= values.length) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
    }
}
