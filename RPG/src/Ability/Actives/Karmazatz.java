package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Karmazatz extends Special
{
	private static boolean targetAll = false;
    private static String name = "Karmazatz";
    private static String desc = "A mystical ritual with unknown consequences.";
    private static String atkDesc = "The spell's effect is already in place.";
    private static int manaCost = 0;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static int dmg = 0;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = false;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {0,0,0,0};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = false;
    
    public Karmazatz(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,6,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Karmazatz(true);
    }
    
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		list.add(EssecneDrain.class);
		list.add(Curse.class);
		list.add(Vampire.class);
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(Reaper.class))
			return true;
		return false;
	}
}
