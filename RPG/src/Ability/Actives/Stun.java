package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Stun extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 8;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Stun";
    private static String desc = "For 3 turns, 50% chance to skip enemy's turn. | Costs 8 mana";
    private static String atkDesc = "A bright light flashes the enemy";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,3,0,3};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Stun(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,15,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Stun(true);
    }
    

	@Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		list.add(StunPlus.class);
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(Sparks.class))
			return true;
		return false;
	}
}
