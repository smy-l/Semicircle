package club.banyuan.skill;

import club.banyuan.character.Fighter;
import club.banyuan.weapon.*;

public class DoubleAttack extends Skill{

    public DoubleAttack() {
        setName("双倍攻击");
    }

    @Override
    public void apply(Fighter from, Fighter to) {
        to.hurt(from.getWeapon().attack() * 2);
    }
}
