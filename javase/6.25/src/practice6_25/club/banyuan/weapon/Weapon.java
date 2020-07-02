package practice6_25.club.banyuan.weapon;

public abstract class Weapon implements WeaponAble{
    private String name;
    private int attackNum;

    public Weapon(String name) {
        this.name = name;
    }

    public int getAttackNum() {
        return attackNum;
    }

    public void setAttackNum(int attackNum) {
        this.attackNum = attackNum;
    }

    @Override
    public  String getName(){
        return name;
    }

    @Override
    public abstract int attack();

}
