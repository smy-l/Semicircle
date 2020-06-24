package club.banyuan.queue;

public class CycleQueue implements Queue {

    private Object[] value;
    private int putIndex = 0;
    private int getIndex = -1;
    private int count = 0;

    public CycleQueue(int capacity) {
        value = new Object[capacity];
    }

    public CycleQueue() {
        this(10);
    }

    public int getPutIndex() {
        return putIndex;
    }

    public int getGetIndex() {
        return getIndex;
    }

    public Object[] getValue() {
        return value;
    }

    @Override
    public void add(Object o) {
        //判断队列是否满，扩容
        putIndex %= value.length;
        if ((putIndex % value.length) == getIndex) {
            Object[] newValue = new Object[value.length * 2];
            for (int i = 0; i < value.length; i++) {
                newValue[i] = value[getIndex % value.length];
                getIndex++;
            }
            putIndex = value.length;
            getIndex = 0;
            value = newValue;
        }

        //添加元素
        value[putIndex] = o;
        putIndex++;
        count++;

        if (getIndex == -1) {
            getIndex = 0;
        }

    }

    @Override
    public Object delete() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return null;
        }
        getIndex = getIndex % value.length;
        Object del = value[getIndex];
        value[getIndex] = null;
        getIndex++;
        count--;
        return del;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    public static void main(String[] args) {
        CycleQueue c1 = new CycleQueue(5);

        c1.add(1);
        c1.add(2);
//        c1.delete();
        c1.add(3);
//        c1.delete();
        c1.add(4);
        c1.add(5);
        c1.add(6);
        c1.add(7);

//        c1.delete();
//        c1.delete();
//        c1.delete();
//        c1.delete();
//        c1.delete();

//        System.out.println("getIndex: " + c1.getGetIndex());
//        System.out.println("putIndex: " + c1.getPutIndex());
//        System.out.println(c1.getValue().length);
        for (int i = 0; i < c1.value.length; i++) {
            System.out.print(c1.value[i] + " ");
        }
    }
}
