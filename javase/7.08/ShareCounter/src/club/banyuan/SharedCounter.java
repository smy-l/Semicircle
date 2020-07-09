package club.banyuan;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedCounter extends Thread {
  static int counter = 0;

  public static void reset() {
    counter = 0;
  }

  public static int increment(int numThreads, int numIncrementsPerThread) throws InterruptedException {

    Lock lock = new ReentrantLock();
    for (int i = 0; i < numThreads; i++) {
      Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
          lock.lock();
          counter += numIncrementsPerThread;
          lock.unlock();
        }
      });
      thread.start();
      thread.join();
    }
    return counter;
  }
}
