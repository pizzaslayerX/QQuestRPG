package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Tornado extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 101;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Tornado";
    private static String desc = "Hits 15 times. Deals 60-90 dmg. Stuns for 1 turn. Cost: 101 Mana";
    private static String atkDesc = "A twister emerges from the heavens!";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,3,0,1,5,15,6};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Tornado(boolean t) throws InterruptedException
    {
       super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,202,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Tornado(true);
    }
    

	@Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		list.add(Tempest.class);
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(PrevailingWinds.class))
			return true;
		return false;
	}
}
