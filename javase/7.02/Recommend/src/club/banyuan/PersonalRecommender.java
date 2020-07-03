package club.banyuan;

import java.util.*;

//PersonalRecommender类包含一个名为likes的HashMap，
// hashMap将人的名字作为key，value是一个LinkedList<String>，包含（书，电影，歌曲等）的名称。
// 使用适当的访问修饰符可防止另一个类直接访问或编辑likes。
public class PersonalRecommender implements Recommender {
    public Map<String, List<String>> likes = new HashMap<>();

    //添加addLikes方法，该方法接收一个人的名字和一个项目的名称，并将该项目添加到该人的List集合中。
    @Override
    public void addLikes(String name, String protect) {
        List<String> newLikeList;
        if (likes.containsKey(name)) {
            newLikeList = likes.get(name);
        }else{
            newLikeList = new LinkedList<>();
        }
        newLikeList.add(protect);
        likes.put(name, newLikeList);
    }

    //添加likesBoth方法，该方法接收一个人的名字和两个项目的名称，并返回一个布尔值，
    // 表示该人是否喜欢这两个项目。如果HashMap中没有给定名称的人，
    // likesBoth应该抛出UnknownPersonException以报告未找到该人。
    @Override
    public boolean likesBoth(String name, String protect1, String protect2) throws UnknownPersonException {
        if (!likes.containsKey(name)) {
            throw new UnknownPersonException();
        }
        return likes.get(name).contains(protect1) && likes.get(name).contains(protect2);
    }

    //添加recommendByPerson方法，该方法接收一个人名作为参数，返回项目的List
    @Override
    public List<String> recommendByPerson(String name){
        List<String> list = likes.get(name);
        Set<String> allProtect = new HashSet<>();
        for (List<String> value : likes.values()) {
            List<String> copyList = new LinkedList<>(value);
            copyList.retainAll(list);
            if(copyList.size() > 0){
                allProtect.addAll(value);
            }
        }
        allProtect.addAll(list);
        return new LinkedList<>(allProtect);
    }

    //添加recommendByProject方法，该方法接收一个项目名作为参数，
    // 返回项目的List，该List中的项目是所有Likes中包含的人中包含有给定项目名称的其他项目的集合
    @Override
    public List<String> recommendByProject(String protect) {
        Set<String> allProtect = new HashSet<>();
        for (List<String> value : likes.values()) {
            if (value.contains(protect)) {
                allProtect.addAll(value);
            }
        }
        return new LinkedList<>(allProtect);
    }

    public Map<String, List<String>> getLikes() {
        return likes;
    }
}
