package Ability.Actives;

import java.util.ArrayList;

import Main.Player;

public class BackKick extends Special
{
    private static int manaCost = 0;
    private static boolean targetAll = false;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Back Kick Combo";
    private static String desc = "Hits twice. Deals 12-24 dmg. Stuns for 1 turn.";
    private static String atkDesc = "You kick the enemy with a big POW!";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg = false;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,3,0,1,5,12,2};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public BackKick(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,30,t);
    }
    
    public static void equip() throws InterruptedException {
    	new BackKick(true);
    }
    

	@Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		list.add(Fury.class);
		list.add(CrossSlash.class);
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(SwordArt.class))
			return true;
		return false;
	}
}
