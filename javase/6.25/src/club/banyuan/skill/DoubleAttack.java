package club.banyuan.skill;

import club.banyuan.character.Fighter;
import club.banyuan.weapon.*;

public class DoubleAttack extends Skill{

    public DoubleAttack() {
        setName("双倍攻击");
        setBlue(3);
    }

    @Override
    public void apply(Fighter from, Fighter to) {
        if(isEnough(from)) {
            from.setBlueVolume(from.getBlueVolume() - getBlue());
            to.hurt(from.getWeapon().attack() * 2);
        }else{
            System.out.println("蓝量不足，使用普通攻击");
            to.hurt(from.getWeapon().attack());
        }
    }
}
