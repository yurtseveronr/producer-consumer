import java.util.Deque;
import java.util.concurrent.Semaphore;

public class Producer extends Thread {

    private Deque<Integer> list;

    private Semaphore semaphore = new Semaphore(1);

    public Producer(Deque<Integer> list) {
        this.list = list;
        setName("Producer");
    }

    @Override
    public void run() {

        int number = 1;
        try {
            while (true) {
                semaphore.acquire();
                list.add(number);
                System.out.println("Added : "+number);
                number++;
            }
        }

        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        finally {
            semaphore.release();
        }


    }
}

