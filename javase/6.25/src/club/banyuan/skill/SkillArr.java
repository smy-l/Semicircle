package club.banyuan.skill;

import club.banyuan.weapon.GanJiang;
import club.banyuan.weapon.TuLongDao;
import club.banyuan.weapon.Weapon;
import club.banyuan.weapon.YiTianJian;

public class SkillArr{
    private final int SIZE = 4;
    public Skill[] skills = new Skill[SIZE];

    public SkillArr(){
        skills[0] = new DoubleAttack();
        skills[1] = new StunAttack();
        skills[2] = new CommanAttack();
        skills[3] = new HitThePoint();
    }
}
