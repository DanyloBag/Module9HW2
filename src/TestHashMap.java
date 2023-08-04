public class TestHashMap {
    public static void main(String[] args) {
        testPutAndGetWithNullKey();
    }

    public static void testPutAndGetWithNullKey() {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();

        myHashMap.put("Key1", 10);
        myHashMap.put("Key2", 20);
        myHashMap.put(null, 30);

        System.out.println("myHashMap.get(\"Key1\") = " + myHashMap.get("Key1"));
        System.out.println("myHashMap.get(\"Key2\") = " + myHashMap.get("Key2"));
        System.out.println("myHashMap.get(null) = " + myHashMap.get(null));
    }
}
