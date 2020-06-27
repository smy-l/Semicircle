package club.banyuan.weapon;

public class GanJiang extends Weapon{

    public GanJiang() {
        super("阳剑-干将");
    }


    private int GJSkill(){
        int random = (int)(Math.random() * 5);
        if(random == 0){
            System.out.println("发动技能，武器伤害50");
            return 50;
        }
        return (int)(Math.random() * 10 + 10);
    }


    @Override
    public int attack(){
        return GJSkill();
    }

}
