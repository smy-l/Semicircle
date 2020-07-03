package club.banyuan;

import java.util.List;

public interface Recommender {
    //添加addLikes方法，该方法接收一个人的名字和一个项目的名称，并将该项目添加到该人的List集合中。
    void addLikes(String name, String protect);

    //添加likesBoth方法，该方法接收一个人的名字和两个项目的名称，并返回一个布尔值，
    // 表示该人是否喜欢这两个项目。如果HashMap中没有给定名称的人，
    // likesBoth应该抛出UnknownPersonException以报告未找到该人。
    boolean likesBoth(String name, String protect1, String protect2) throws UnknownPersonException;

    //添加recommendByPerson方法，该方法接收一个人名作为参数，返回项目的List
    List<String> recommendByPerson(String name);

    //添加recommendByProject方法，该方法接收一个项目名作为参数，
    // 返回项目的List，该List中的项目是所有Likes中包含的人中包含有给定项目名称的其他项目的集合
    List<String> recommendByProject(String protect);
}
