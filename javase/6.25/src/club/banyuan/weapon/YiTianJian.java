package club.banyuan.weapon;

public class YiTianJian extends Weapon{

    private String name = "倚天剑";
    private int attackNum = 15;

    public YiTianJian() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int attack() {
        return attackNum;
    }

}
