package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class FatalBlow extends Special
{
	private static boolean targetAll = false;
    private static int manaCost;
    private static int heal;
    private static int percentHeal;
    private static String name = "Fatal Blow";
    private static String desc = "Deals 50 dmg without using a turn. Stuns for 1 turn.";
    private static String atkDesc = "You strike the enemy's weak spot!";
    private static int dmg = 50;
    private static boolean pureDmg;
    private static boolean doesDmg = true;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,3,0,1};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = false;
    
    public FatalBlow(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,118,t);
    }
    
    public static void equip() throws InterruptedException {
    	new FatalBlow(true);
    }
    

	@Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(Feint.class) && Player.checkAbility(Focus.class))
			return true;
		return false;
	}
}
