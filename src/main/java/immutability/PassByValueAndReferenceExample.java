package immutability;

import java.util.ArrayList;

public class PassByValueAndReferenceExample {

    // all object are passed by reference whereas primitive are passed by value

    public static void main(String[] args) {

        int num = 10;
        String name = "Divya";

        Integer variable = 20;
        var lists = new ArrayList<Integer>();
        lists.add(4);
        lists.add(1);
        lists.add(8);
        System.out.println(num);
        System.out.println(name);
        System.out.println(variable);
        System.out.println(lists);
        testMethod(num, name, variable, lists);
        System.out.println(num);
        System.out.println(name);
        System.out.println(variable);
        System.out.println(lists);

    }

    public static void testMethod(int num, String name, Integer variable, ArrayList<Integer> lists) {

        System.out.println(num);
        System.out.println(name);
        System.out.println(variable);
        System.out.println(lists);

        num=5;
        name="Anita";
        variable=900;
        lists.add(90);
        lists.add(67);

        System.out.println(num);
        System.out.println(name);
        System.out.println(variable);
        System.out.println(lists);
    }


}
