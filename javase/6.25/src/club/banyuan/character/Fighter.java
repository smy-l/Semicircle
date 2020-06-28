package club.banyuan.character;

import club.banyuan.skill.*;
import club.banyuan.weapon.*;

public class Fighter {
    private String name;
    private int hp = 1000;
    private int mp = 50;
    private Weapon weapon;
    private Skill[] skills;
    private int vertigo = 0;

    public Fighter(String name, Weapon weapon, Skill[] skills) {
        this.name = name;
        this.weapon = weapon;
        this.skills = skills;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getVertigo() {
        return vertigo;
    }

    public void setVertigo(int vertigo) {
        this.vertigo = vertigo;
    }

    public void attack(Fighter fighter) {
        int skillIndex = (int) (Math.random() * skills.length);
        System.out.println(getName() + "使用了" + getWeapon().getName() + "向" + fighter.getName() + "发起" + skills[skillIndex].getName() + "！");
        skills[skillIndex].apply(this, fighter);
    }

    public void hurt(int hurt) {
        setHp(hp - hurt);
        System.out.println(getName() + "受到伤害" + hurt + "点");
        System.out.println("剩余生命值为：" + getHp());
    }

    public void vertigo(int rounds) {
        vertigo += rounds;
        System.out.println(getName() + "眩晕1回合");
    }

    public void recover() {
        setVertigo(getVertigo() - 1);
    }

    public boolean isAlive(){
        return getHp() > 0;
    }
}
