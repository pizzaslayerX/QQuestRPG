package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Thunder extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 0;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Thunder";
    private static String desc = "Deals 33 shock dmg. Stuns for 2 turns";
    private static String atkDesc = "A mighty lightning bolt strikes the enemy";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,3,0,2,13,33,1};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Thunder(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,60,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Thunder(true);
    }
    
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		list.add(PrevailingWinds.class);
		list.add(ChainLightning.class);
		list.add(ReverentThunder.class);
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(StunPlus.class))
			return true;
		return false;
	}
}
