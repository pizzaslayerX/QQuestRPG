package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class HellVoid extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 185;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Hellish Void";
    private static String desc = "Silence for 3 turns. Deals 198 fire dmg over 6 turns. | Cost: 185 mana";
    private static String atkDesc = "The enemy is trapped in a nightmarish hell.";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,1,33,6,2,0,3};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public HellVoid(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,300,t);
    }
    
    public static void equip() throws InterruptedException {
    	new HellVoid(true);
    }
    
    
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(EternalFlames.class) && Player.checkAbility(SilenceTwo.class))
			return true;
		return false;
	}
}
