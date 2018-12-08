package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class ChainLightning extends Special
{
	private static boolean targetAll = true;
    private static int manaCost = 50;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Chain Lightning";
    private static String desc = "Deals 38 shock dmg. Stuns for 1 turns | Targets All Enemies | Cost: 50 Mana";
    private static String atkDesc = "Bolts of electricty surge from enemy to enemy.";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,3,0,1,13,38,1};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public ChainLightning(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,80,t);
    }
    
    public static void equip() throws InterruptedException {
    	new ChainLightning(true);
    }
    
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(Thunder.class) && Player.checkAbility(StaticShock.class))
			return true;
		return false;
	}
}

