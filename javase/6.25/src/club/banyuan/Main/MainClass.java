package club.banyuan.Main;

import club.banyuan.character.Fighter;
import club.banyuan.skill.*;
import club.banyuan.weapon.*;

public class MainClass {
    public static void main(String[] args) {
        //创建武器组
//        Weapon[] weapons = new Weapon[3];
//        weapons[1] = new TuLongDao();
//        weapons[0] = new YiTianJian();
//        weapons[2] = new GanJiang();
        WeaponArr w1 = new WeaponArr();

        //创建技能组
//        Skill[] skills = new Skill[4];
//        skills[0] = new DoubleAttack();
//        skills[1] = new StunAttack();
//        skills[3] = new CommanAttack();
//        skills[2] = new HitThePoint();
        SkillArr s1 = new SkillArr();

        //创建人物
//        Fighter zhangWuJi = new Fighter("张无忌", weapons[0], skills);
//        Fighter mieJueShiTai = new Fighter("灭绝师太", weapons[1], skills);
//        Fighter player1 = new Fighter("金毛狮王", weapons[2], skills);
        Fighter zhangWuJi = new Fighter("张无忌", w1.weapons[0], s1.skills);
        Fighter mieJueShiTai = new Fighter("灭绝师太", w1.weapons[1], s1.skills);
        Fighter jinMaoShiWang = new Fighter("金毛狮王",w1.weapons[2],s1.skills);

        //过程
//        Process.process(zhangWuJi, mieJueShiTai);
//        Process.process(mieJueShiTai, jinMaoShiWang);
        Process.process(zhangWuJi,jinMaoShiWang);

    }
}
