package practice6_15.club.banyuan.stringBuffer;

public class StringBuffer {
    char[] value = new char[100];
    int count = 0;

    /**
     * 接收字符串
     */
    public void append(String str) {
        int len = str.length();
        str.getChars(0, len, value, count);
        count += len;
    }

    /**
     * 接收字符
     */
    public void append(char str) {
        value[count] = str;
        count++;
    }

    /**
     * 将之前接收到的字符拼接到一起返回
     */
    public String toString() {
        char[] temp  = new char[count];
        System.arraycopy(value,0,temp,0,count);
        return String.valueOf(temp);
    }

    /**
     * 清除之前的而输入内容
     */
    public void clear() {
        value = new char[100];
        count = 0;
    }

    /**
     * 将之前的输入内容反转
     */
    public String reverse() {
        char[] temp = new char[count];
        for (int i = 0; i < count; i++) {
            temp[count - 1 - i] = value[i];
        }
        return String.valueOf(temp);
    }

    /**
     * 将指定位置的字符串反转
     * from 从0起始
     * to 不包含在内
     * 即[from,to)
     * 例如 abcdefg => reverse(1,3) => acbdefg
     */
    public String reverse(int from, int to) {
        if (from < 0 || to > count || (to - from < 2)) {
            System.out.println("位置输入有误");
            return null;
        }

        char[] temp = new char[count];
        for (int i = from; i < to; i++) {
            temp[to - i + 1] = value[i];
        }

//        for(int j = 0; j < from; j++){
//            temp[j] = value[j];
//        }
        System.arraycopy(value, 0, temp, 0, from);

//        for (int i = to; i < count; i++) {
//            temp[i] = value[i];
//        }
        if (count - to >= 0) {
            System.arraycopy(value, to, temp, to, count - to);
        }

        return String.valueOf(temp);
    }

    public String wordReversal(){
        char[] temp = new char[count];
        System.arraycopy(value,0,temp,0,count);
        int from = 0;
        int to = 0;
        for(int i = from; i < count; i++){
            if(value[i] == ' '){
                to = i;
                int count = 0;
                for (int j = from; j < to; j++) {
                    temp[j] = value[to - count - 1];
                    count++;
                }
                from = to + 1;
            }
        }
        return String.valueOf(temp);
    }



    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        s1.append("123 456 789");
        s1.append('s');

//        System.out.println(s1.toString());
//        System.out.println(s1.reverse(2,6));
//        System.out.println(s1);
//        s1.clear();
//        s1.append("123123");
//        System.out.println(s1);
        System.out.println(s1.toString());
        System.out.println(s1.wordReversal());

    }
}
