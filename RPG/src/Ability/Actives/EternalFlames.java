package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class EternalFlames extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 99;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Eternal Flames";
    private static String desc = "Deals 11 Fire dmg for an infinite amount of turns. | Cost: 99 mana";
    private static String atkDesc = "Inextinguishable flames engulf the enemy!";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,1,11,999};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public EternalFlames(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,130,t);
    }
    public static void equip() throws InterruptedException {
    	new EternalFlames(true);
    }
    
    @Override
   	public ArrayList<Class<? extends Special>> getNewSpecial() {
   		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
   		list.add(Ifrit.class);
   		list.add(HellVoid.class);
   		return list;
   	}

   	@Override
   	public boolean isLearnable() {
   		if(Player.checkAbility(Immolate.class))
   			return true;
   		return false;
   	}
}
