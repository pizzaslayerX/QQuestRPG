package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Galvanize extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 50;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Galvanize";
    private static String desc = "+25 dmg and +10% Speed for 3 turns. | Does not use a turn | Cost: 50 mana";
    private static String atkDesc = "An immense amount of energy surges through your body. You feel empowered!";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,32,10,3,6,25,3};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = false;
    
    public Galvanize(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,90,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Galvanize(true);
    }
    
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(OhmicSurge.class))
			return true;
		return false;
	}
}
