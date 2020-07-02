package practice6_25.club.banyuan.weapon;

public class TuLongDao extends Weapon {

    public TuLongDao() {
        super("屠龙刀");
    }

    @Override
    public int attack(){
        return (int)(Math.random() * 11 + 20);
    }
}
