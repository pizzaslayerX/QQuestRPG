package Ability.Actives;

import java.util.ArrayList;

import Main.Player;

public class Purify extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 50;
    private static int heal;
    private static int percentHeal = 0;
    private static String name = "Purification";
    private static String desc = "Removes all of your status effects | Cost: 50 mana";
    private static String atkDesc = "You purge your soul of all impurities";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,15,0,0};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Purify(boolean t) throws InterruptedException
    {
       super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,90,t);
    }
    public static void equip() throws InterruptedException {
    	new Purify(true);
    }
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		list.add(Blessing.class);
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(Brilliance.class))
			return true;
		return false;
	}
}
