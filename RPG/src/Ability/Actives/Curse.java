package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Curse extends Special
{
	private static boolean targetAll = false;
    private static String name = "Curse";
    private static String desc = "Inflicts Curse for 3 turns. | Cost: 45 Mana";
    private static String atkDesc = "You place a hex on the enemy. Spooky!";
    private static int manaCost = 45;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static int dmg = 0;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,47,15,3};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Curse(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,50,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Curse(true);
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
