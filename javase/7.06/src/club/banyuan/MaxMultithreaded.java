package club.banyuan;

class MaxThread extends Thread {
    private int lo, hi;
    private int[] arr;
    private double max = 0;

    public MaxThread(int[] arr, int lo, int hi) {
        this.lo = lo;  // 直角边
        this.hi = hi;  // 斜边
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i = lo; i < hi; i++) {
            double tempMax = Math.sin(arr[i]);
            if (max < tempMax) {
                max = tempMax;
            }
        }
    }

    public double getMax() {
        return max;
    }
}

public class MaxMultithreaded {

    /**
     * 计算数组元素的sin值之后，返回最大值。
     *
     * @param arr 目标数组
     * @return sin(数组元素)的最大值
     * @throws InterruptedException 不应该出现此异常
     */
    public static double max(int[] arr, int numThreads) throws InterruptedException {
        int len = arr.length;
        double max = -Double.MAX_VALUE;

        //创建线程
        MaxThread[] ms = new MaxThread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            ms[i] = new MaxThread(arr, (i * len) / numThreads, ((i + 1) * len / numThreads));
            ms[i].start();
        }

        // 等待线程完成并得出结果。
        for (int i = 0; i < numThreads; i++) {
            ms[i].join();
            double tempMax = ms[i].getMax();
            if (max < tempMax) {
                max = tempMax;
            }
        }
        return max;
    }
}
