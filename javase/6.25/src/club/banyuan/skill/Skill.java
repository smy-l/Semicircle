package club.banyuan.skill;

import club.banyuan.character.Fighter;

import javax.security.auth.login.CredentialNotFoundException;

public abstract class Skill implements SkillAble {
    private String name;
    private int skillMP;

    public void setName(String name) {
        this.name = name;
    }

    public void setSkillMP(int skillMP) {
        this.skillMP = skillMP;
    }

    public int getSkillMP() {
        return skillMP;
    }

    public String getName() {
        return name;
    }

    public abstract void apply(Fighter from, Fighter to);

    public void noMP(Fighter from, Fighter to) {
        System.out.println("蓝量不足，使用普通攻击");
        to.hurt(from.getWeapon().attack());
    }

    public boolean isEnoughAttack(Fighter from) {
        if (from.getMp() > skillMP) {
            int overageMP = from.getMp() - getSkillMP();
            from.setMp(overageMP);
            return true;
        }
        return false;
    }

}
