package practice6_23.club.banyuan.queue;

import java.util.Arrays;

public class ArrayList {

    private Object[] value;
    private int count;

    public ArrayList(int capacity) {
        value = new Object[capacity];
    }

    public ArrayList() {
        this(10);
    }

    /**
     * 更新数组指定下标的元素
     *
     * @param index   待更新的元素下标
     * @param element 更新后的元素对象
     * @return 被替换掉的旧对象
     */
    public Object set(int index, Object element) {
        if (index < 0 || index >= value.length) {
            System.out.println("输入不合法！");
            return null;
        }

        Object temp = value[index];
        value[index] = element;
        return temp;
    }

    /**
     * 查询指定位置下标的元素
     *
     * @param index 需要判断index是否合法
     * @return 返回查找到的元素，找不到返回null
     */
    public Object get(int index) {
        if (index < 0 || index >= value.length) {
            System.out.println("输入不合法！");
            return null;
        }

        if (value[index] != null) {
            return value[index];
        }

        return null;
    }

    /**
     * 清空集合内容
     */
    public void clear() {
        Arrays.fill(value, null);
        count = 0;
    }

    /**
     * 删除指定下标的元素
     *
     * @param index 元素下标
     * @return 将删除的元素返回，如果下标不合理，返回null
     */
    public Object remove(int index) {
        if (index < 0 || index >= count) {
            System.out.println("输入不合法！");
            return null;
        }

        Object del = value[index];
        System.arraycopy(value, index + 1, value, index, count - index - 1);
        value[count - 1] = null;
        count--;
        return del;
    }

    /**
     * 查找并删除元素
     *
     * @param o 通过目标元素 equals 方法判断是否匹配，
     *          需要判断o是否为null，如果传入null，则用== 进行比较
     * @return
     */
    public boolean remove(Object o) {
        for (int i = 0; i < count; i++) {
            if ((o == null && value[i] == null) || (value[i].equals(o))) {
                remove(i);
                return true;
            }
        }

        return false;
    }


    /**
     * 添加一个元素
     *
     * @param o
     * @return 添加成功后返回true 失败返回false
     */
    public boolean add(Object o) {
        if (count == value.length) {
            Object[] newValue = new Object[value.length * 2];
            System.arraycopy(value, 0, newValue, 0, count);
            newValue[value.length] = o;
            count++;
            value = newValue;
            return true;
        }

        value[count] = o;
        count++;
        return true;
    }

    /**
     * @return 数组中没有元素，返回true
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 返回数组中保存的元素个数
     *
     * @return
     */
    public int size() {
        return count;
    }


    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        System.out.println("数组中保存的元素个数" + arrayList.size());
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        System.out.println("数组中保存的元素个数" + arrayList.size());


        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.value[i] + " ");
        }
        System.out.println("\n");

        System.out.println("=====set=====");
        arrayList.set(5, 1010);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.value[i] + " ");
        }
        System.out.println("\n");

        System.out.println("=====get=====");
        Object o = arrayList.get(1);
        int a = (int) o;
        System.out.println(a + "\n");

        System.out.println("=====remove(index)=====");
        arrayList.remove(5);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.value[i] + " ");
        }
        System.out.println("\n");

        System.out.println("=====remove(elem)=====");
        arrayList.remove(o);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.value[i] + " ");
        }
        System.out.println("\n");


        System.out.println("isEmpty: " + arrayList.isEmpty());
        arrayList.clear();
        System.out.println("isEmpty: " + arrayList.isEmpty());

    }
}