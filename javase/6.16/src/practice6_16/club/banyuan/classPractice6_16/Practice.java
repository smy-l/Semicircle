package practice6_16.club.banyuan.classPractice6_16;

public class Practice {

    public static String shiftOne(String str){
        String one = str.substring(1);
//        char[] temp = str.toCharArray();
//        char two = temp[0];
        char two = (str.toCharArray())[0];
        return one + two;
    }

    public static void main(String[] args) {
        String str = "123456";
        System.out.println(shiftOne(str));
    }

}
