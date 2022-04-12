package generics;

public class Test {

    public static void main(String[] args) {
        MyGenericClass<String> myGenericClass = new MyGenericClass<>("Divya");
        myGenericClass.getTypeDetails();
        System.out.println(myGenericClass.getType());

        MyGenericClass<Integer> myGenericClass1 = new MyGenericClass<>(10);
        myGenericClass1.getTypeDetails();
        System.out.println(myGenericClass1.getType());

        MyGenericClass<Double> myGenericClass2 = new MyGenericClass<>(3444.01D);
        myGenericClass2.getTypeDetails();
        System.out.println(myGenericClass2.getType());

    }
}
