package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class UberCure extends Special
{
	private static boolean targetAll = false;
    private static String name = "Uber Cure";
    private static String desc = "Heals 60% of max HP without using a turn | Cost: 120 Mana";
    private static String atkDesc = "All of your troubles float away...";
    private static int manaCost = 120;
    private static int heal;
    private static int percentHeal = 60;
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = false;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = false;
    
    public UberCure(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,110,t);
    }
    
    public static void equip() throws InterruptedException {
    	new UberCure(true);
    }
    
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(CurePlus.class))
			return true;
		return false;
	}
}
