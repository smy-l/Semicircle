package club.banyuan;

import java.util.Date;

public class HourMeter implements Timer {
    private boolean isStart;
    private Long start = 0L;
    private Long end = 0L;


    @Override
    public void start() throws IllegalStateException {
        if (!isStart) {
            throw new IllegalStateException();
        }
        start = System.currentTimeMillis();
        isStart = true;
    }

    @Override
    public void stop() throws IllegalStateException {
        if (isStart) {
            throw new IllegalStateException();
        }
        end = System.currentTimeMillis();
        isStart = false;
    }

    @Override
    public void reset() {
        start = 0L;
        end = 0L;
    }

    @Override
    public long getTimeMillisecond() {
        return end - start;
    }
}
