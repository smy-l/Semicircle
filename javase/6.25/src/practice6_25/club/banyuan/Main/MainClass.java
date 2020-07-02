package practice6_25.club.banyuan.Main;

import practice6_25.club.banyuan.character.Fighter;
import practice6_25.club.banyuan.skill.*;
import practice6_25.club.banyuan.weapon.*;

public class MainClass {
    public static void main(String[] args) {
        //创建技能组
        Skill[] skills = new Skill[]{
                new DoubleAttack(),
                new CommanAttack(),
                new StunAttack(),
                new HitThePoint()
        };

        //创建人物
        Fighter zhangWuJi = new Fighter("张无忌", new TuLongDao(), skills);
        Fighter mieJueShiTai = new Fighter("灭绝师太", new YiTianJian(), skills);
        Fighter jinMaoShiWang = new Fighter("金毛狮王",new GanJiang(), skills);

        //过程
//        Process.process(zhangWuJi, mieJueShiTai);
//        Process.process(mieJueShiTai, jinMaoShiWang);
        Process.process(zhangWuJi,jinMaoShiWang);

    }
}
