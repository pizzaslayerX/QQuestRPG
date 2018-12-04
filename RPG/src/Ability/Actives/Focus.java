package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Focus extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 27;
    private static int heal;
    private static int percentHeal = 12;
    private static String name = "Focus";
    private static String desc = "Heals 12% of HP and grants +5 dmg for 2 turns. | Cost: 27 mana";
    private static String atkDesc = "The world slows down. You regain your compsure";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,6,5,2};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Focus(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,42,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Focus(true);
    }
    

	@Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		list.add(FatalBlow.class);
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(SpiritBlade.class))
			return true;
		return false;
	}
}
