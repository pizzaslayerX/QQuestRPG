package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class PotentCurse extends Special
{
	private static boolean targetAll = true;
    private static String name = "Potent Curse";
    private static String desc = "Inflicts Strong Curse for 3 turns to all targets. | Cost: 60 HP";
    private static String atkDesc = "You place a hex on the enemy. Spooky!";
    private static int manaCost = 0;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static int dmg = 0;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,47,30,3,9,60,0};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public PotentCurse(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,95,t);
    }
    
    public static void equip() throws InterruptedException {
    	new PotentCurse(true);
    }
    
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(Curse.class))
			return true;
		return false;
	}
}
