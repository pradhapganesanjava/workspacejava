package Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CollectionsSyncLatch {

    // Should be replaced with Collections.synchronizedList(new ArrayList<Integer>())
    public List<Integer> completed = new ArrayList<Integer>();

    /**
     * @param args
     */
    public static void main(String[] args) {
    	CollectionsSyncLatch r = new CollectionsSyncLatch();
        ExecutorService exe = Executors.newFixedThreadPool(30);
        int tasks = 100;
        CountDownLatch latch = new CountDownLatch(tasks);
        for (int i = 0; i < tasks; i++) {
            exe.submit(r.new Task(i, latch));
        }
        try {
            latch.await();
            System.out.println("Summary:");
            System.out.println("Number of tasks completed: "
                    + r.completed.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exe.shutdown();
    }

    class Task implements Runnable {

        private int id;
        private CountDownLatch latch;

        public Task(int id, CountDownLatch latch) {
            this.id = id;
            this.latch = latch;
        }

        public void run() {
            Random r = new Random();
            try {
                Thread.sleep(r.nextInt(500)); //Actual work of the task
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            completed.add(id);
            latch.countDown();
        }
    }
}