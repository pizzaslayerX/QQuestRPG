package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class ReverentThunder extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 53;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Reverent Thunder";
    private static String desc = "Deals 52 shock dmg. Disables enemies for 2 turns. | Cost: 53 mana";
    private static String atkDesc = "An empowered thunderbolt fries the enemy!";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,17,0,2,13,62,1};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public ReverentThunder(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,140,t);
    }
    
    public static void equip() throws InterruptedException {
    	new ReverentThunder(true);
    }
    
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		list.add(Tempest.class);
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(Thunder.class))
			return true;
		return false;
	}
}
