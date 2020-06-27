package club.banyuan.skill;

import club.banyuan.character.Fighter;

public class StunAttack extends Skill{
    public StunAttack() {
        setName("眩晕攻击");
    }

    @Override
    public void apply(Fighter from, Fighter to) {
        to.hurt((int)(from.getWeapon().attack() * 0.5));
        to.setDizziness(to.getDizziness() + 1);
    }
}
