package club.banyuan;

import java.util.Date;

public class HourMeter implements Timer {
    private Long time = 0L;
    private Long start = 0L;
    private Long end = 0L;

    @Override
    public void start() throws IllegalStateException {
        if (start == 0L) {
            start = System.currentTimeMillis();
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public void stop() throws IllegalStateException {
        if (end == 0 && start != 0) {
            end = System.currentTimeMillis();
        } else {
            throw new IllegalStateException();
        }
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
