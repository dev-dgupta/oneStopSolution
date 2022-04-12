package oopsConcept;


/*
 *
 * Five different ways to create object
 *
 * */

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

class Student implements Cloneable, Serializable {
    private int rollNo;
    private String firstName;

    public Student() {
    }

    public Student(int rollNo, String firstName) {
        this.rollNo = rollNo;
        this.firstName = firstName;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNo == student.rollNo && firstName.equals(student.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo, firstName);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class LearnAboutObject {
    public static void main(String[] args) {

        // first way
        Student s1 = new Student(1, "Divya");
        System.out.println("s1:: " + s1.toString());

        Student s2 = s1;
        s2.setRollNo(2);
        s2.setFirstName("Anita");
        System.out.println("s2:: " + s2.toString());
        System.out.println("s1:: " + s1.toString());
        //second way
        try {
            var studentCons = Student.class.getConstructor();
            Student s6 = studentCons.newInstance();
            System.out.println("s6:: " + s6.toString());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //third way
        try {
            Student s3 = (Student) s1.clone();
            System.out.println("s3:: " + s3.toString());
            s3.setRollNo(5);
            s3.setFirstName("Devesh");
            System.out.println("s3:: " + s3.toString());
            System.out.println("s1:: " + s1.toString());
            System.out.println("s2:: " + s2.toString());
            Student s4 = (Student) s3.clone();
            System.out.println("s4:: " + s4.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //fourth way
        try {
            Student s5 = Student.class.newInstance();
            s5.setRollNo(3);
            s5.setFirstName("Nitu");
            System.out.println("s5:: " + s5.toString());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }


}
