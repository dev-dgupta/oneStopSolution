package designPatterns.creationalPattern.singletons;

import java.io.Serializable;

public class MySingleton implements Serializable, Cloneable {

    // volatile, so that every thread knows if the variable has been changed
    private volatile static MySingleton instance;

    // to avoid calling of constructor outside class
    private MySingleton() {

    }

    public static MySingleton getInstance() {
        // instance first check
        if (instance == null) {
            // synchronize on instance object so that no two threads can enter the block
            synchronized (instance) {
                // just to ensure no new thread commits happen to the instance once previous thread leaves the
                // synchronized block
                if (instance == null) {
                    instance = new MySingleton();
                }
            }
        }
        return instance;
    }


    // to avoid creation of new object through serialization
    public Object readResolve() {
        return instance;
    }

    // to avoid cloning of the instance
    @Override
    public MySingleton clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("You cannot clone a singleton class");
    }
}
