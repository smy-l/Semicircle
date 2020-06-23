package club.banyuan.queue;

public class ArrayQueue implements Queue{

    private ArrayList arrayList;

    @Override
    public void add(Object o) {
        arrayList.add(o);
    }

    @Override
    public Object delete() {
        return arrayList.remove(0);
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }
}
