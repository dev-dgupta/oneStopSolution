//package immutability;
//
//
//import java.util.Arrays;
//
///*
//* the key of the hashmap must be immutable
//* */
//public class MyHashMap {
//
//    private int[] arr=new int[16];
//
//
//    public void put(String key, Object value){
//
//        int hash=key.hashCode()
//
//
//
//    }
//
//    public void get(String key){
//
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        MyHashMap myHashMap = (MyHashMap) o;
//        return Arrays.equals(arr, myHashMap.arr);
//    }
//
//    @Override
//    public int hashCode() {
//        return Arrays.hashCode(arr);
//    }
//}
