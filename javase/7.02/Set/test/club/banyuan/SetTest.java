package club.banyuan;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    @Test
    public void testAdd() {
        ClassTest class1 = new ClassTest();
        Set<Student> test1 = new HashSet<>();
        test1.add(new Student(1, "张三", 10));
        test1.add(new Student(2, "张三", 10));
        test1.add(new Student(3, "张三", 10));
        Assert.assertTrue(class1.studentSet.isEmpty());
        class1.addMoreInformation(test1);
        Assert.assertEquals(3, class1.studentSet.size());
        Assert.assertFalse(class1.studentSet.isEmpty());
    }

    @Test
    public void testSort() {
        ClassTest class1 = new ClassTest();
        Set<Student> test1 = new HashSet<>();
        test1.add(new Student(1, "张三", 13));
        test1.add(new Student(3, "张三", 11));
        test1.add(new Student(2, "张三", 12));
        class1.addMoreInformation(test1);
        Assert.assertEquals("张三", class1.sortAge().get(1).getName());
        Assert.assertEquals(2, class1.sortId().get(1).getId());
    }

    @Test
    public void testAddStu(){
        ClassTest class1 = new ClassTest();
        Assert.assertTrue(class1.studentSet.isEmpty());
        class1.addStu(new Student(1, "张三", 11));
        class1.addStu(new Student(3, "赵六", 13));
        class1.addStu(new Student(2, "王五", 12));
        class1.addStu(new Student(4, "张三", 14));
        Assert.assertFalse(class1.studentSet.isEmpty());
//        Assert.assertTrue(class1.studentSet.isEmpty());
    }

}
