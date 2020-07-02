package practice6_25.club.banyuan.weapon;

public class GanJiang extends Weapon{

    public GanJiang() {
        super("阳剑-干将");
    }

    private int GJSkill(){
        int random = (int)(Math.random() * 5);
        if(random == 0){
            System.out.println("发动武器技能，伤害60");
            return 60;
        }
        return (int)(Math.random() * 11 + 15);
    }

    @Override
    public int attack(){
        return GJSkill();
    }

}
