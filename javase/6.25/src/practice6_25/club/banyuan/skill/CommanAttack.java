package practice6_25.club.banyuan.skill;

import practice6_25.club.banyuan.character.Fighter;

public class CommanAttack extends Skill{
    public CommanAttack(){
        setName("普通攻击");
    }

    @Override
    public void apply(Fighter from, Fighter to) {
        to.hurt(from.getWeapon().attack());
    }
}
