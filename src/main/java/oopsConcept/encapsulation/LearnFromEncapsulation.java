package oopsConcept.encapsulation;

/*
* Encapsulation states that all the data and methods to access that data are binded in a single entity.
*
*
* */
public class LearnFromEncapsulation {

    public static void main(String[] args) {
        var account = new Account();
        account.deposit(10);
        account.withdraw(5);
        System.out.println(account.getBalance());

    }
}
