package collectionsExample;


import java.util.*;

/*
 * the key of the hashmap must be immutable
 * */
public class CustomizedHashMap {

    private int capacity = 16;
    private List[] backedArray;

    public CustomizedHashMap() {
        this.backedArray = new LinkedList[capacity];
    }

    public CustomizedHashMap(int capacity) {
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

    public static void main(String[] args) {
        CustomizedHashMap map = new CustomizedHashMap(10);
        map.put("Divya", 1);
        map.put("Alia", 2);
        map.put("Ranbir", 3);

        System.out.println(map.get("Divya"));
        System.out.println(map.get("Alia"));

        for (String key : map.keySet()) {
            System.out.println("Key: " + key + ", Val: " + map.get(key));
        }
        map.put("Devesh", 2);
        map.put("Divya", 5);
        map.put("Akash", 6);
        for (String key : map.keySet()) {
            System.out.println("Key: " + key + ", Val: " + map.get(key));
        }
        map.remove("Divya");
        map.put("Vaanya", 8);
        for (String key : map.keySet()) {
            System.out.println("Key: " + key + ", Val: " + map.get(key));
        }

    }

    private Set<String> keySet() {
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
