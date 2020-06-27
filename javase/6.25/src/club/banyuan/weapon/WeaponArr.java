package club.banyuan.weapon;

public class WeaponArr {
    private final int SIZE = 3;
    public Weapon[] weapons = new Weapon[SIZE];

    public WeaponArr(){
        weapons[0] = new TuLongDao();
        weapons[1] = new YiTianJian();
        weapons[2] = new GanJiang();
    }
}
