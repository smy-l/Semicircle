package practice6_25.club.banyuan.skill;

import practice6_25.club.banyuan.character.Fighter;

public class HitThePoint extends Skill {
    public HitThePoint() {
        setName("穿透攻击");
        setSkillMP(5);
    }

    private int successAttack(Fighter from){
        int random = (int)(Math.random() * 2);
        if(random == 1){
            System.out.println("命中弱点，效果拔群");
            return (from.getWeapon().attack() * 3);
        }

        System.out.println("打偏了,效果减半");
        return (from.getWeapon().attack() / 2);
    }

    @Override
    public void apply(Fighter from, Fighter to) {
        if(isEnoughAttack(from)) {
            int overageMP = from.getMp() - getSkillMP();
            from.setMp(overageMP);
            to.hurt(successAttack(from));
        }else{
            noMP(from, to);
        }
    }
}
