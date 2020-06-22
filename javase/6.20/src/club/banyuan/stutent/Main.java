package club.banyuan.stutent;

public class Main {
    public static void main(String[] args) {
        EleStudent eleStudent = new EleStudent("三年级", "张三");
        MidStudent midStudent = new MidStudent("初一", "李四");
        HighStudent highStudent = new HighStudent("高三", "王五");

        System.out.println(eleStudent.study());
        System.out.println(midStudent.study());
        System.out.println(highStudent.study());
    }
}
