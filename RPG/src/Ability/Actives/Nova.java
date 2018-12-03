package Ability.Actives;

import java.util.ArrayList;

import Main.Player;

public class Nova extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 0;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Nova";
    private static String desc = "Deals 10 pure Dmg without using a turn";
    private static String atkDesc = "A fiery blast hits the enemy";
    private static int dmg = 10;
    private static boolean pureDmg = true;
    private static boolean doesDmg = true;
    private static boolean statusEffect = false;
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = false;
     private static int[] statusVal = {0,0,0};
     
    public Nova(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,15,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Nova(true);
    }
    
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		list.add(Explosion.class);
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(Burst.class))
			return true;
		return false;
	}
}
