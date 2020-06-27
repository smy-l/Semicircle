package club.banyuan.Main;

import club.banyuan.character.Fighter;
import club.banyuan.skill.*;
import club.banyuan.weapon.*;

public class MainClass {
    public static void main(String[] args) {
        //创建武器组
        Weapon[] weapons = new Weapon[2];
        weapons[0] = new YiTianJian();
        weapons[1] = new TuLongDao();

        //创建技能组
        Skill[] skills = new Skill[2];
        skills[0] = new DoubleAttack();
        skills[1] = new StunAttack();

        //创建人物
        Fighter zhangWuJi = new Fighter("张无忌",weapons[1],skills);
        Fighter mieJueShiTai = new Fighter("灭绝师太",weapons[0],skills);

        //过程
//        Process.start(zhangWuJi,mieJueShiTai);
//        Process.end(zhangWuJi,mieJueShiTai);
        Process.process(zhangWuJi,mieJueShiTai);

    }
}
