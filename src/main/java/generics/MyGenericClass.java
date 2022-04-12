package generics;


/*
* Before 1.5, we were able to add any type to an arraylist.
* This used to create many run time issues. To stop it, we introduced generics.
* To ensure compatibility with earlier versions, Type erasure was introduced with removes the generics at the time of
* compilation.
* */
public class MyGenericClass<T> {

    T obj;

    public MyGenericClass(T obj) {
        this.obj = obj;
    }

    public void getTypeDetails(){
        System.out.println("Type used in my generic class "+obj.getClass().getName());
    }

    public T getType(){
        return obj;
    }

}
