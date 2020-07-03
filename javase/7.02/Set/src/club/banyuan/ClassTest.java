package club.banyuan;

import java.util.*;

public class ClassTest {

    Set<Student> studentSet = new LinkedHashSet<>();
    public static final int INFORMATION_SIZE = 3;

    public static void main(String[] args) {
        ClassTest class1 = new ClassTest();
//        Set<Student> test1 = new LinkedHashSet<>();
        class1.addStu(new Student(1, "张三", 11));
        class1.addStu(new Student(3, "赵六", 13));
        class1.addStu(new Student(2, "王五", 12));
        class1.addStu(new Student(4, "张三", 14));

//        class1.addMoreInformation(class1);
        printStudent(class1.studentSet);

        System.out.println("===========");
        printStudent(class1.sortAge());

        System.out.println("===========");
        printStudent(class1.sortId());
    }

    public void addMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生id 姓名 年龄: ");
        while (true) {
            String str = scanner.nextLine();
            if (str.equalsIgnoreCase("quit")) {
                break;
            }
            String[] tokens = str.split(" ");
            if (tokens.length == INFORMATION_SIZE) {
                int id = Integer.parseInt(tokens[0]);
                String strName = tokens[1];
                int age = Integer.parseInt(tokens[2]);
                this.studentSet.add(new Student(id, strName, age));
            } else {
                System.out.println("输入有误！");
            }
        }
    }

    public void addMoreInformation(Set<Student> students) {
        studentSet.addAll(students);
    }
    public void addStu(Student s1){
        studentSet.add(s1);
    }


    public static void printStudent(Set<Student> studentSet) {
        for (Student student : studentSet) {
            System.out.println(student);
        }
    }
    public static void printStudent(List<Student> studentSet) {
        for (Student student : studentSet) {
            System.out.println(student);
        }
    }

    public  List<Student> sortAge() {
        Set<Student> sortByAgeDsc = new TreeSet<>((o1, o2) -> o2.getAge() - o1.getAge());
        sortByAgeDsc.addAll(studentSet);
        return new ArrayList<>(sortByAgeDsc);
    }

    public List<Student> sortId() {
        Set<Student> sortByIdAsc = new TreeSet<>(Comparator.comparingInt(Student::getId));
        sortByIdAsc.addAll(studentSet);
        return new ArrayList<>(sortByIdAsc);
    }

}


