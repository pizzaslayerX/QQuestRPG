package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class EssenceDrain extends Special
{
	private static boolean targetAll = false;
    private static String name = "Essence Drain";
    private static String desc = "Inflict Bleed for 20% of HP and heal for 30 HP over 4 turns | Cost: 78 Mana";
    private static String atkDesc = "You place a hex on the enemy. Spooky!";
    private static int manaCost = 68;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static int dmg = 0;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,45,20,4,8,30,4};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public EssenceDrain(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,80,t);
    }
    
    public static void equip() throws InterruptedException {
    	new EssenceDrain(true);
    }
    
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		list.add(PotentCurse.class);
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(Karmazatz.class)) 
			return true;
		return false;
	}
}
