package multithreading.producerConsumerProblem;


import java.util.*;
import java.util.ArrayList;

public class ProducerConsumerProblem {
    volatile static List<Integer> products = new ArrayList<>();

    public static void main(String[] args) {

        ProducerConsumerProblem producerConsumerProblem = new ProducerConsumerProblem();
        new Thread(() -> producerConsumerProblem.consume(products)).start();
        new Thread(() -> producerConsumerProblem.producer(products)).start();

    }

    synchronized void producer(List products) {
        while (products.size() < 10) {
            System.out.println("Produce");
            products.add(new Integer(1));
            notify();
            if (products.size() == 10) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    synchronized void consume(List products) {

        while (products.size() > 0) {
            System.out.println("Consume");
            products.remove(new Integer(1));
            notify();

            if(products.size()==0){
                System.out.println("Underflow");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


