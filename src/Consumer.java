import java.util.Deque;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Consumer extends Thread {

    private Deque<Integer> list;

    private Semaphore semaphore = new Semaphore(1);

    public Consumer(Deque<Integer> list) {
        this.list = list;
        setName("Consumer");
    }

    @Override
    public void run() {

        try {

            while (true) {

                if(list.isEmpty()) {
                    continue;
                }

                semaphore.acquire();
                list.removeFirst();
                //Thread.sleep(1000);
                System.out.println("Deleting last element");
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
