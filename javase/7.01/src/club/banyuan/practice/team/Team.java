package club.banyuan.practice.team;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Iterator;

public class Team {

    List<Player> starting = new ArrayList<>();
    List<Player> substitute = new ArrayList<>();

    //添加成员
    public void add(Player player) {
        if (!starting.contains(player) && starting.size() < 5) {
            starting.add(player);
        } else {
            substitute.add(player);
        }
    }

    //获取球员位置信息
    private Player getByPosition(List<Player> players, String position){
        for (Player player : players) {
            if (player.getPosition().equals(position)){
                return player;
            }
        }
        throw new RuntimeException("没有找到该位置球员");
    }

    //替换相同位置的球员，从替补位置，放置到首发位置
    public void replace(Player player){
        Player temp = getByPosition(starting,player.getPosition());
        starting.remove(temp);
        substitute.remove(player);
        starting.add(player);
        substitute.add(temp);
        substitute.sort(Comparator.comparingInt(Player::getPositionIndex));
        starting.sort(Comparator.comparingInt(Player::getPositionIndex));
    }

    //接收一个球员类，从替补或首发移除该球员
    public void remove(Player player){
        if(starting.remove(player)){
            Player temp = getByPosition(substitute, player.getPosition());
            starting.add(temp);
            substitute.remove(temp);
            starting.sort(Comparator.comparingInt(Player::getPositionIndex));
        }else{
            substitute.remove(player);
        }
    }


    //把传入的名单列表中的替补的球员替换到首发名单中
    public void replace(List<Player> players){
        List<Player> all = new ArrayList<>(players);
        all.addAll(substitute);

        starting.clear();
        if(players.size() > 5){
            throw new RuntimeException("人数不合法");
        }
        starting.addAll(players);

        List<String> positions = new ArrayList<>();
        for (Player player : starting) {
            if (positions.contains(player.getPosition())){
                throw new RuntimeException("位置重复了");
            }
            positions.add(player.getPosition());
        }

        Iterator<Player> iterator = all.iterator();
        while(iterator.hasNext()){
            Player next = iterator.next();
            if(!positions.contains(next.getPosition())){
                starting.add(next);
                positions.add(next.getPosition());
                iterator.remove();
            }
        }

        if(starting.size() < 5){
            throw new RuntimeException("人数不够了");
        }
        starting.sort(Comparator.comparingInt(Player::getPositionIndex));
        substitute = all;
        substitute.removeAll(starting);
        substitute.sort(Comparator.comparingInt(Player::getPositionIndex));

    }

    public void print() {
        System.out.println("====首发====");
        System.out.println(starting);
        System.out.println("====替补====");
        System.out.println(substitute);
    }

}
