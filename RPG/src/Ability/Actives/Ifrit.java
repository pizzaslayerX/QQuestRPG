package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Ifrit extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 141;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Wrath of the Ifrit";
    private static String desc = "Deals 166 Fire dmg. -90% dmg for 2 turns | Cost: 141 mana";
    private static String atkDesc = "You channel the spirit of a flame demon to smite your foe!";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,1,166,1,43,90,2};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Ifrit(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,280,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Ifrit(true);
    }
    
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(EternalFlames.class))
			return true;
		return false;
	}
}
