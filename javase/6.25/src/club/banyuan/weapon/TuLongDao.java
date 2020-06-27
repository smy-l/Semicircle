package club.banyuan.weapon;

public class TuLongDao extends Weapon {
    private String name = "屠龙刀";
    private int attackNum;

    public TuLongDao() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int attack() {
        return attackNum = (int) (Math.random() * 11 + 20);
    }

}
