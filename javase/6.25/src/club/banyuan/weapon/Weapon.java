package club.banyuan.weapon;

public abstract class Weapon implements WeaponAble{

    @Override
    public abstract String getName();

    @Override
    public abstract int attack();
}
