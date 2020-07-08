package club.banyuan;

import java.util.concurrent.locks.ReentrantLock;

public class SharedCounter extends Thread{
    static int counter = 0;

    public static void reset() {
        counter = 0;
    }

    public static int increment(int numThreads, int numIncrementsPerThread) throws InterruptedException {
        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    counter += numIncrementsPerThread;
                }
            });
            thread.start();
            thread.join();
        }
        return counter;
    }
}
