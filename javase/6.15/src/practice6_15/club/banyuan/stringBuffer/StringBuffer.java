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

    //仅反转from到to
    public char[] onlyReverse(int from, int to){
        char[] charArr = new char[count];
        int numCount = 0;
        for (int i = from; i < to; i++) {
            charArr[i] = value[to - numCount - 1];
            numCount++;
        }
        return charArr;
    }

    /**
     * 将之前的输入内容反转
     */
    public String reverse() {
        char[] temp = onlyReverse(0,count);
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

        //反转from到to
        char[] temp = onlyReverse(from,to);

        //copy from 之前
        System.arraycopy(value, 0, temp, 0, from);
//        for(int j = 0; j < from; j++){
//            temp[j] = value[j];
//        }

        //copy from 之后
        if (count - to >= 0) {
//        for (int i = to; i < count; i++) {
//            temp[i] = value[i];
//        }
            System.arraycopy(value, to, temp, to, count - to);
        }

        return String.valueOf(temp);
    }

    //单词反转
    public String wordReversal(){
        char[] temp = new char[count];
        System.arraycopy(value,0,temp,0,count);
        int from = 0;
        int to;
        for(int i = from; i <= count; i++){
            if(value[i] == ' ' || i == count){
                to = i;
                System.arraycopy(onlyReverse(from,to),from,temp,from,to - from);
//                int numCount = 0;
//                for (int j = from; j < to; j++) {
//                    temp[j] = value[to - numCount - 1];
//                    numCount++;
//                }
                from = to + 1;
            }
        }
        return String.valueOf(temp);
    }

    public String shiftOne(String str){
        String one = str.substring(1);
//        char[] temp = str.toCharArray();
//        char two = temp[0];
        char two = (str.toCharArray())[0];
        return one + two;
    }

    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        s1.append("123 456 789");
        s1.append('s');
        System.out.println(s1.toString());
        System.out.println();

        System.out.println("=====反转=====");
        System.out.println(s1.reverse());
        System.out.println();

        System.out.println("=====反转2-8字符=====");
        System.out.println(s1.toString());
        System.out.println(s1.reverse(2,8));
        System.out.println();

        System.out.println("=====清除后再增加=====");
        System.out.println(s1);
        s1.clear();
        s1.append("To be or not to be");
//        System.out.println(s1);
        System.out.println(s1.toString());
        System.out.println();

        System.out.println("=====单词反转=====");
        System.out.println(s1.wordReversal());

    }
}
