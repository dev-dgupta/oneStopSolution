import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeIterators extends Thread {

    // provides us with iterators that do allow you to modify list while iterating
    // over it in multithreaded or single threaded environement
    static List<String> courses = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        FailSafeIterators failFastVsFailSafeIterators = new FailSafeIterators();
        failFastVsFailSafeIterators.start();

        courses.add("Java");
        courses.add("AWS");
        courses.add("Python");
        courses.add("Docker");

        Iterator<String> it = courses.iterator();

        while (it.hasNext()) {
            Thread.sleep(1000);
            System.out.println(it.next());
            courses.remove(it.next());
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
