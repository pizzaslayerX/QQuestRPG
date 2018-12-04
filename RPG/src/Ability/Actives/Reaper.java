package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Reaper extends Special
{
	private static boolean targetAll = false;
    private static String name = "Reaper's Call";
    private static String desc = "15 pure dmg, heals 17 HP, +3 dmg for 1 turn. | Cost: 35 Mana";
    private static String atkDesc = "You command a Reaper to steal the enemy's soul";
    private static int manaCost = 35;
    private static int heal = 17;
    private static int percentHeal = 0;
    private static int dmg = 15;
    private static boolean pureDmg = true;
    private static boolean doesDmg = true;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,6,3,1};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Reaper(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,40,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Reaper(true);
    }
    
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		list.add(KarmaZatz.class);
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(DrainTouch.class))
			return true;
		return false;
	}
}
