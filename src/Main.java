import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Deque<Integer> list = new LinkedList<>();
        Producer producer  = new Producer(list);
        Consumer consumer  = new Consumer(list);

        try {
            producer.start();
            consumer.start();
            producer.join();
        }

        catch (InterruptedException  interruptedException) {
            interruptedException.printStackTrace();
        }

    }
}
