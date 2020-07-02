package club.banyuan;

import java.util.*;

public class ClassTest {

    Set<Student> studentSet = new LinkedHashSet<>();
    public static final int INFORMATION_SIZE = 3;

    public static void main(String[] args) {
        ClassTest class1 = new ClassTest();
        Set<Student> test1 = new LinkedHashSet<>();
        test1.add(new Student(1, "张三", 11));
        test1.add(new Student(3, "赵六", 13));
        test1.add(new Student(2, "王五", 12));
        test1.add(new Student(4, "张三", 14));

        class1.addMoreInformation(test1);
        printStudent(class1.studentSet);

        System.out.println("===========");
        printStudent(sortAge(class1.studentSet));

        System.out.println("===========");
        printStudent(sortId(class1.studentSet));
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

    public static List<Student> sortId(Set<Student> studentSet) {
        Set<Student> tempStudent = new TreeSet<>(Comparator.comparingInt(Student::getId));
        tempStudent.addAll(studentSet);
        return new ArrayList<>(tempStudent);
    }

    public static List<Student> sortAge(Set<Student> studentSet) {
        Set<Student> tempStudents = new TreeSet<>((o1, o2) -> o2.getAge() - o1.getAge());
        tempStudents.addAll(studentSet);
        return new ArrayList<>(tempStudents);
    }

}


