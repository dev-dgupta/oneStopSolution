package typesOfReferences;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/*
*
1). Order of Strength –> Strong Ref > Soft Ref > Weak Ref > Phantom Ref.

2). Strong Ref == Object Ref.
    If the object gets abandoned from a Strong Ref, it could become a Soft, Weak or Phantom & depending on
    that its GC approach will vary. I do feel though that since most of us don’t specify these reference types,
    if a Strong Ref (OR Object) gets abandoned, it by default is collected in the next cycle of GC
    (as determined by the JVM), which makes it a Weak Ref.

3). Soft Ref will only be collected when there is memory pressure (as mentioned in this section).

4). Weak Ref will be collected immediately (i.e. on the next cycle of GC as determined by the JVM).

5). As for the Phantom Ref, the only extra info I have about it is that it is the weakest of all references
    & may or may not be collected by the GC Thread. It depends on your approach.
*
* */
public class TestReferences {

    public static void main(String[] args) {
//        strongReference();
//        weakReference();
        // weak references are of 2 types: soft and phantom
//        softReference();
//        phantomReference();
    }

    // referrent is never directly accessible through API
    // An object is phantomly referenced after it has been finalized.
    // Before removing the object from memory, it is kept in reference queue.
    //
    // First, it can be used instead of a finalize method, guaranteeing that the object is not
    // resurrected during finalization. This allows the object to be garbage collected in a single cycle,
    // rather than needing to wait for a second GC cycle to ensure that it has not been resurrected.
    //
    // A second use is to detect exactly when an object has been removed from memory
    // (by using in combination with a ReferenceQueue object), ensuring that its memory is
    // available, for example deferring allocation of a large amount of memory (e.g., a large image)
    // until previous memory is freed.
    private static void phantomReference() {
    }

    // only garbage collected when JVM needs memory
    // memory sensitive caches use these
    // If object is cleared from the memory, it will return null.
    private static void softReference() {
        Employee employee = new Employee(1, "John");   //not eligible for GC
        SoftReference<Employee> emp = new SoftReference(employee);
        System.out.println("Before null: " + employee.toString());
        employee = null;     //eligible for GC
        System.out.println("Employee: " + employee);
        // you get the employee object back, if yet not cleared from memory
        System.out.println(emp.get());
        employee = emp.get();
        System.out.println("After null: " + employee.toString());
    }

    // is marked for garbage collection as soon as strong reference is made null
    // the object can be retrieved by using get() method, until memory not cleared
    // used in WeakHashmaps whose keys (entry objects) are weak references
    // these references are used in real time applications while establishing a
    // DBConnection which might be cleaned up by Garbage collector when the application
    // using the database gets closed.
    // they are GCed when JVM runs garbage collector thread, does not waits for full memory,
    // like for soft references
    private static void weakReference() {
        Employee employee = new Employee(1, "John");   //not eligible for GC
        WeakReference<Employee> emp = new WeakReference(employee);
        System.out.println("Before null: " + employee.toString());
        employee = null;     //eligible for GC, also emp is available for garbage collection (with value intact).
        System.out.println("Employee: " + employee);
        //employee object can be retrieved by get() method until the emp gets GCed by JVM
        System.out.println(emp.get());
        employee = emp.get();
        System.out.println("After null: " + employee.toString());
    }

    //garbage is collected only when the object reference is made null
    private static void strongReference() {
        Employee employee = new Employee(1, "John");   //not eligible for GC
        employee = null;     //eligible for GC
        System.out.println("Employee: " + employee);
    }


}
