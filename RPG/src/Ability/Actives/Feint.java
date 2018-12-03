package Ability.Actives;

import java.util.ArrayList;

import Main.Player;

public class Feint extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 0;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Feint";
    private static String desc = "+35 dmg: 2 turns, Stun: 1 turn, -20 your def: 1 turn | Cost: 25 HP.";
    private static String atkDesc = "Purposefully getting hit leaves the enemy vulnerable!";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg = false;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {4,6,35,2,9,25,0,3,0,1,42,20,1};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Feint() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,65);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new Feint());
    }
    

	@Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		list.add(FatalBlow.class);
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(Fury.class))
			return true;
		return false;
	}
}
