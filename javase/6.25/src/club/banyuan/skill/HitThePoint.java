package club.banyuan.skill;

import club.banyuan.character.Fighter;

public class HitThePoint extends Skill {
    public HitThePoint() {
        setName("穿透攻击");
        setBlue(5);
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
        if(isEnough(from)) {
            from.setBlueVolume(from.getBlueVolume() - getBlue());
            to.hurt(successAttack(from));
        }else{
            System.out.println("蓝量不足，使用普通攻击");
            to.hurt(from.getWeapon().attack());
        }
    }
}
