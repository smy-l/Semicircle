package club.banyuan.skill;

import club.banyuan.character.Fighter;

public class StunAttack extends Skill {

    public StunAttack() {
        setName("眩晕攻击");
        setBlue(3);
    }

    @Override
    public void apply(Fighter from, Fighter to) {
        if (isEnough(from)) {
            from.setBlueVolume(from.getBlueVolume() - getBlue());
            to.hurt((int) (from.getWeapon().attack() * 0.5));
            to.setDizziness(to.getDizziness() + 1);
        } else {
            System.out.println("蓝量不足，使用普通攻击");
            to.hurt(from.getWeapon().attack());
        }

//        to.hurt((int)(from.getWeapon().attack() * 0.5));
//        to.setDizziness(to.getDizziness() + 1);
    }
}
