package typesOfCloning;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShallowCloningExample {

    public static void main(String[] args) {

        List<String> associatedLst= new ArrayList<>();
        associatedLst.add("Divya");
        associatedLst.add("Divya1");
        associatedLst.add("Divya2");

        ShallowCloneClass shallowCloneClass = new ShallowCloneClass(1,"ABC", associatedLst);

        System.out.println(shallowCloneClass.toString());
        associatedLst.add("Divya");

        // the change is visible in the object too
        System.out.println(shallowCloneClass.toString());


    }

}


class ShallowCloneClass{

    private int id;
    private String name;
    private List<String> associatedList;

    public ShallowCloneClass(int id, String name, List<String> associatedList) {
        this.id = id;
        this.name = name;
        this.associatedList = associatedList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShallowCloneClass that = (ShallowCloneClass) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(associatedList, that.associatedList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, associatedList);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAssociatedList() {
        return associatedList;
    }

    public void setAssociatedList(List<String> associatedList) {
        this.associatedList = associatedList;
    }

    @Override
    public String toString() {
        return "ShallowCloneClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", associatedList=" + associatedList +
                '}';
    }
}
