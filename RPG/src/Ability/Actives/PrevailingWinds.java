package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class PrevailingWinds  extends Special
{
	private static boolean targetAll = true;
    private static int manaCost = 85;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Prevailing Winds";
    private static String desc = "+15% Speed. Enemies: -10% speed, dmg, and def 3 turns | Targets All Enemies | Cost: 85 mana";
    private static String atkDesc = "Large gusts of winds sweep through the battlefield.";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {4,32,15,3,35,10,3,43,10,3,41,10,3};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public PrevailingWinds(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,100,t);
    }
    
    public static void equip() throws InterruptedException {
    	new PrevailingWinds(true);
    }
    
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		list.add(Tornado.class);
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(Thunder.class) && Player.checkAbility(Gale.class))
			return true;
		return false;
	}
}
