package immutability;

import java.util.ArrayList;
import java.util.HashMap;

public class TestingImmutability {

    public static void main(String[] args) {

        var list=new ArrayList<String>();

        list.add("q");
        list.add("w");
        list.add("e");

        var map=new HashMap<Integer,String>();
        map.put(1,"d");
        map.put(2,"div");
        map.put(3,"divya");

        ImmutableClassExample immutableClassExample=new ImmutableClassExample(2,"ÄBC",list,map);
        System.out.println(immutableClassExample.toString());
        list.add("r");
        list.add("t");

        map.put(1,"ani");
        map.put(4,"divyyy");
        map.remove(2);
        System.out.println(immutableClassExample.toString());

        try {
            ImmutableClassExample im1= (ImmutableClassExample) immutableClassExample.clone();
            System.out.println(im1.toString());
            list.add("y");
            list.remove("r");
            System.out.println(im1.toString());

            System.out.println(im1==immutableClassExample);
            System.out.println(im1.equals(immutableClassExample));

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }



    }


}
