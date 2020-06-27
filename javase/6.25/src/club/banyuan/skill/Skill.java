package club.banyuan.skill;

import club.banyuan.character.Fighter;
import club.banyuan.weapon.*;

public abstract class Skill implements SkillAble {
    private String name;
    private int blue;

    public void setName(String name) {
        this.name = name;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getBlue() {
        return blue;
    }

    public boolean isEnough(Fighter from) {
        return from.getBlueVolume() > blue;
    }

    public String getName() {
        return name;
    }

    public abstract void apply(Fighter from, Fighter to);

}
