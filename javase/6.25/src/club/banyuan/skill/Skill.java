package club.banyuan.skill;

import club.banyuan.character.Fighter;
import club.banyuan.weapon.*;

public abstract class Skill implements SkillAble{
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public abstract void apply(Fighter from, Fighter to);

}
