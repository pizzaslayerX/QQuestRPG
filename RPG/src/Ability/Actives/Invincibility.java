package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Invincibility extends Special
{
	private static boolean targetAll = false;
    private static int manaCost;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Invincibility";
    private static String desc = "+100 def and Silences for 2 turn. Does not use turn.";
    private static String atkDesc = "God Mode = true";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,4,100,2,2,0,2};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = false;
    
    public Invincibility(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,330,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Invincibility(true);
    }
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(Untouchable.class))
			return true;
		return false;
	}
}

