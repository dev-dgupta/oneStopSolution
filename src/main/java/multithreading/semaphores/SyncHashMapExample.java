package multithreading.semaphores;


import multithreading.producerConsumerProblem.volatileProblems.SequenceGeneratorUsingVolatile;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * the key of the hashmap must be immutable
 * */

public class SyncHashMapExample {
    static CustomizedSynchronizedHashMap map = new CustomizedSynchronizedHashMap(10);
    // removes livelock situation
    Lock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
        new Thread(new Thread3()).start();
    }

    static class Thread1 implements Runnable {

        @Override
        public void run() {
            map.put("Divya", 1);
            map.put("Alia", 2);
            map.put("Ranbir", 3);
            System.out.println("Thread 1");
            for (String key : map.keySet()) {
                System.out.println("Key: " + key + ", Val: " + map.get(key));
            }
        }
    }

    static class Thread2 implements Runnable {

        @Override
        public void run() {
            map.put("Divya", 133);
            map.put("Alia", 98);
            map.put("Ranbir", 31);
            System.out.println("Thread 2");
            for (String key : map.keySet()) {
                System.out.println("Key: " + key + ", Val: " + map.get(key));
            }
        }
    }

    static class Thread3 implements Runnable {

        @Override
        public void run() {
            map.put("Divya", 9);
            map.put("Alia", 5);
            map.put("Ranbir", 8);
            System.out.println("Thread 3");
            for (String key : map.keySet()) {
                System.out.println("Key: " + key + ", Val: " + map.get(key));
            }
        }
    }
}


class CustomizedSynchronizedHashMap {

    private int capacity = 16;
    private List[] backedArray;

    public CustomizedSynchronizedHashMap() {
        this.backedArray = new LinkedList[capacity];
    }

    public CustomizedSynchronizedHashMap(int capacity) {
        this.capacity = capacity;
        this.backedArray = new LinkedList[capacity];
    }

    static class Entry {
        String key;
        Object value;

        public Entry(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return key.equals(entry.key) && value.equals(entry.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }


    public boolean put(String key, Object value) {
        int index = getIndexFor(key);
        List<Entry> entryList = backedArray[index];
        Entry newObj = new Entry(key, value);
        System.out.println("Curr thread start " + Thread.currentThread().getName());
        synchronized (Entry.class) {
            System.out.println("Curr thread within " + Thread.currentThread().getName());
            if (Objects.isNull(entryList) || entryList.isEmpty()) {
                entryList = new LinkedList<>();
                entryList.add(newObj);
            } else {
                boolean objFound = false;
                for (Entry entry : entryList) {
                    if (key.equals(entry.key)) {
                        entry.value = value;
                        objFound = true;
                        break;
                    }
                }
                if (!objFound)
                    entryList.add(newObj);
            }
            System.out.println("Curr thread before end " + Thread.currentThread().getName());
        }
        System.out.println("Curr thread end " + Thread.currentThread().getName());
        backedArray[index] = entryList;
        return true;
    }

    public Object get(String key) {
        int index = getIndexFor(key);
        List<Entry> entryList = backedArray[index];
        if (Objects.isNull(entryList))
            return null;
        Optional<Entry> entryObj =
                entryList.stream().filter(entry -> key.equals(entry.key)).findFirst();

        return entryObj.isPresent() ? entryObj.get().value : null;
    }

    private int getIndexFor(String key) {
        int hash;
        if (key == null)
            hash = 0;
        else
            hash = key.hashCode();
        return Math.abs(hash % capacity);
    }

    Set<String> keySet() {
        var keys = new HashSet<String>();
        for (List<Entry> entryList : backedArray) {
            if (Objects.nonNull(entryList)) {
                for (Entry entry : entryList) {
                    keys.add(entry.key);
                }
            }
        }
        return keys;
    }

    private boolean remove(String key) {
        int index = getIndexFor(key);
        var m = new HashMap<>();
        List<Entry> entryList = backedArray[index];
        for (Entry entry : entryList) {
            if (key.equals(entry.key)) {
                entryList.remove(entry);
                return true;
            }
        }
        return false;
    }
}

