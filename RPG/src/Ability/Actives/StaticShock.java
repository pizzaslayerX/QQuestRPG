package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class StaticShock extends Special
{
	private static boolean targetAll = true;
    private static int manaCost = 8;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Static Shock";
    private static String desc = "11 shock dmg to all enemies | Does not use a turn | Cost: 10 HP";
    private static String atkDesc = "*Zap* *Zap* *Zap* everyone gets shocked!";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,13,11,1,9,10,0};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = false;
    
    public StaticShock(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,20,t);
    }
    
    public static void equip() throws InterruptedException {
    	new StaticShock(true);
    }
    

	@Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		list.add(ChainLightning.class);
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(Sparks.class))
			return true;
		return false;
	}
}
