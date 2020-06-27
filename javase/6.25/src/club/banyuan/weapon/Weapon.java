package club.banyuan.weapon;

public abstract class Weapon implements WeaponAble{
    private String name;
    private int attackNum;

    public Weapon(String name) {
        this.name = name;
    }

    @Override
    public  String getName(){
        return name;
    }

    @Override
    public int attack(){
        return attackNum;
    }

}
