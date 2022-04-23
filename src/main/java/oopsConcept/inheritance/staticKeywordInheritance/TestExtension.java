package oopsConcept.inheritance.staticKeywordInheritance;


class Test {
    public static void method1() {
        System.out.println("I am first");
    }

    public static void method1(int val) {
        System.out.println("I am second with a value: " + val);
    }

    public void method2(String str) {
        System.out.println("I am printing method2 input: " + str);
    }

}

public class TestExtension extends Test {
    public static void method1() {
        System.out.println("I am third");
    }

    public void method2(String str) {
        System.out.println("Method2 of extension class: " + str);
    }

    public static void main(String[] args) {
        TestExtension obj1 = new TestExtension();
        Test obj2 = new TestExtension();


        obj1.method1();   // I am third
        obj1.method2("Hello"); // Method2 of extension class Hello
        obj2.method1(); // I am first ---> this is called because the object is created with Test class
                        // (so test class static method will be called)
        obj2.method2("Hello2");  // Method2 of extension clas Hello2
        TestExtension.method1(4);  //I am second with a value: 4
        TestExtension.method1();  //I am third
    }
}