package club.banyuan;

public class Main {
    public static void main(String[] args) throws UnknownPersonException {
        Recommender p = new PersonalRecommender();
        p.addLikes("张三", "1");
        p.addLikes("张三", "2");
        p.addLikes("张三", "3");
        p.addLikes("张三", "4");

        p.addLikes("李四", "1");
        p.addLikes("李四", "2");
        p.addLikes("李四", "7");
        p.addLikes("李四", "8");

        p.addLikes("王五", "1");
        p.addLikes("王五", "11");
        p.addLikes("王五", "9");
        p.addLikes("王五", "10");

        System.out.println(p.likesBoth("李四","1","6"));
        System.out.println(p.recommendByPerson("李四"));
        System.out.println(p.recommendByProject("1"));
    }
}
