package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Simmer extends Special
{
	private static boolean targetAll = true;
    private static int manaCost = 0;
    private static int heal = 0;
    private static String name = "Simmer";
    private static String desc = "Deals 21 Fire dmg over 3 turns | Targets All Enemies";
    private static String atkDesc = "Hot liquid engulfs the battlefield";
    private static int percentHeal = 0;
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,1,7,3};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Simmer(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,35,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Simmer(true);
    }
    
    @Override
   	public ArrayList<Class<? extends Special>> getNewSpecial() {
   		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
   		list.add(Scald.class);
   		list.add(Eruption.class);
   		return list;
   	}

   	@Override
   	public boolean isLearnable() {
   		if(Player.checkAbility(Ignite.class))
   			return true;
   		return false;
   	}
}
