package club.banyuan.skill;

import club.banyuan.character.Fighter;

public class StunAttack extends Skill {

    public StunAttack() {
        setName("眩晕攻击");
        setSkillMP(3);
    }

    @Override
    public void apply(Fighter from, Fighter to) {
        if (isEnoughAttack(from)) {
            int hurt = from.getWeapon().attack() / 2;
            to.hurt(hurt);
            to.setVertigo(1);
        } else {
            noMP(from, to);
        }
    }
}
