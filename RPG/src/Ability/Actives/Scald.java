package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Scald extends Special
{
	private static boolean targetAll = true;
    private static int manaCost = 0;
    private static int heal = 0;
    private static String name = "Scald";
    private static String desc = "Deals 30 Fire dmg. -18% Fire Resist for 3 turns. | Targets All Enemies";
    private static String atkDesc = "The skin of your enemies begins to boil away.";
    private static int percentHeal = 0;
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,1,30,1,23,18,3};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Scald(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,70,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Scald(true);
    }
    
    @Override
   	public ArrayList<Class<? extends Special>> getNewSpecial() {
   		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
   		return list;
   	}

   	@Override
   	public boolean isLearnable() {
   		if(Player.checkAbility(Simmer.class))
   			return true;
   		return false;
   	}
}
