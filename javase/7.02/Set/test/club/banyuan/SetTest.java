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
        Assert.assertEquals(12, ClassTest.sortAge(class1.studentSet).get(1).getAge());
        Assert.assertEquals(2, ClassTest.sortId(class1.studentSet).get(1).getId());
    }

}
