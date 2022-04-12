import java.util.*;

public class FailFastIterators extends Thread {

    // provides us with iterators that do not allow you to modify list while iterating over it
    // throws ConcurrentModificationException
    static List<String> courses = new ArrayList<>();

    // provides us with iterators that do allow you to modify list while iterating
    // over it in multithreaded or single threaded environement
    static List<String> failSafeCourses = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        FailFastIterators failFastVsFailSafeIterators = new FailFastIterators();
        failFastVsFailSafeIterators.start();

        courses.add("Java");
        courses.add("AWS");
        courses.add("Python");
        courses.add("Docker");

        Iterator<String> it = courses.iterator();

        while (it.hasNext()) {
            Thread.sleep(1000);
            System.out.println(it.next());
        }

        System.out.println(courses);

    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        courses.add("Kubernetes");
    }


}
