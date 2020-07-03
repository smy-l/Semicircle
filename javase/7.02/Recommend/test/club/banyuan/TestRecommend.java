package club.banyuan;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TestRecommend {
    @Test
    public void testLikesBoth() throws UnknownPersonException {
        Recommender p = new PersonalRecommender();
        p.addLikes("张三", "1");
        p.addLikes("张三", "2");
        p.addLikes("张三", "3");
        p.addLikes("张三", "4");

        p.addLikes("李四", "1");
        p.addLikes("李四", "6");
        p.addLikes("李四", "7");
        p.addLikes("李四", "8");

        p.addLikes("王五", "1");
        p.addLikes("王五", "11");
        p.addLikes("王五", "9");
        p.addLikes("王五", "10");

        Assert.assertFalse(p.likesBoth("王五","1","2"));
        Assert.assertTrue(p.likesBoth("李四","1","6"));
        System.out.println(Arrays.asList("1","2","3"));
    }
}
