package club.banyuan;

public class ReverseHelloMultithreaded {
    public static void doReverseHello() {
        for (int i = 50; i > 0; i--) {
            int finalI = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Hello from thread " + finalI);
                }
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
