package practice6_25.club.banyuan.skill;

import practice6_25.club.banyuan.character.Fighter;

public class DoubleAttack extends Skill{

    public DoubleAttack() {
        setName("双倍攻击");
        setSkillMP(3);
    }

    @Override
    public void apply(Fighter from, Fighter to) {
        if(isEnoughAttack(from)) {
            int hurt = from.getWeapon().attack() * 2;
            to.hurt(hurt);
        }else{
            noMP(from, to);
        }
    }
}
