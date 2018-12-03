package Ability.Actives;

import java.util.ArrayList;

import Main.Player;

public class Omnislash extends Special
{
	private static boolean targetAll = true;
    private static int manaCost = 0;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Cross Slash";
    private static String desc = "Targets all enemies | Hits 8 times. Deals 48-88 dmg";
    private static String atkDesc = "You lacerate the enemy in the blink of an eye. 2 EZ.";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg = false;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,5,11,8};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = false;
    
    public Omnislash() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,125);
    }
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new Omnislash());
    }
    

	@Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(CrossSlash.class))
			return true;
		return false;
	}
}
