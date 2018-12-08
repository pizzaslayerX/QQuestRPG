package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class OhmicSurge extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 41;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Ohmic Surge";
    private static String desc = "-25% enemy shock resist for 3 turns. 24 shock damage over 3 turns. | Cost: 41 mana";
    private static String atkDesc = "A mighty lightning bolt strikes the enemy";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,25,25,3,13,8,3};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public OhmicSurge(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,65,t);
    }
    
    public static void equip() throws InterruptedException {
    	new OhmicSurge(true);
    }
    
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		list.add(Galvanize.class);
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(ThermoElectricity.class))
			return true;
		return false;
	}
}
