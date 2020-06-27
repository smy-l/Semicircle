package club.banyuan.character;

import club.banyuan.skill.*;
import club.banyuan.weapon.*;

public class Fighter {
    private String name;
    private int bloodVolume = 1000;
    private Weapon weapon;
    private Skill[] skills;
    private int dizziness = 0;

    public Fighter(String name, Weapon weapon, Skill[] skills) {
        this.name = name;
        this.weapon = weapon;
        this.skills = skills;
    }

    public Skill[] getSkills() {
        return skills;
    }

    public void setSkills(Skill[] skills) {
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBloodVolume() {
        return bloodVolume;
    }

    public void setBloodVolume(int bloodVolume) {
        this.bloodVolume = bloodVolume;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getDizziness() {
        return dizziness;
    }

    public void setDizziness(int dizziness) {
        this.dizziness = dizziness;
    }

    public void attack(Fighter fighter) {
        int skillIndex = (int) (Math.random() * skills.length);
        System.out.println(getName() + "向" + fighter.getName() + "发起" + skills[skillIndex].getName() + "！");
        skills[skillIndex].apply(this, fighter);
    }

    public void hurt(int hurt) {
        setBloodVolume(bloodVolume - hurt);
        System.out.println(getName() + "受到伤害" + hurt + "点");
    }

    public void vertigo(int rounds) {
        System.out.println(getName() + "眩晕1回合");
        rounds = rounds + 1;
    }

    public void recover() {
        setDizziness(getDizziness() - 1);
    }
}
