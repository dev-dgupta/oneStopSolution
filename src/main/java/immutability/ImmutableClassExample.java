package immutability;

import java.util.*;

public final class ImmutableClassExample implements Cloneable{

    private final int id;
    private final String name;
    private final List<String> listOfCourses;
    private final Map<Integer, String> keyValueMap;

    public ImmutableClassExample(int id, String name, List<String> listOfCourses, Map<Integer, String> keyValueMap) {
        this.id = id;
        this.name = name;
        this.listOfCourses = getListOfCourses(listOfCourses);
        this.keyValueMap = getKeyValueMap(keyValueMap);
    }

    public String getName() {
        return name;
    }

    //deep cloning
    public List<String> getListOfCourses(List<String> listOfCourses) {
        return new ArrayList<>(listOfCourses);
    }

    // deep cloning
    public Map<Integer, String> getKeyValueMap(Map<Integer, String> keyValueMap) {
        var newKeyValueMap = new HashMap<Integer, String>();
        for (Integer key : keyValueMap.keySet()) {
            newKeyValueMap.put(key, keyValueMap.get(key));
        }
        return newKeyValueMap;
    }

    @Override
    public String toString() {
        return "immutability.ImmutableClassExample{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", listOfCourses=" + listOfCourses +
                ", keyValueMap=" + keyValueMap +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableClassExample that = (ImmutableClassExample) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(listOfCourses, that.listOfCourses) && Objects.equals(keyValueMap, that.keyValueMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, listOfCourses, keyValueMap);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
