package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Blessing extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 70;
    private static int heal = 50;
    private static int percentHeal = 0;
    private static String name = "Blessing";
    private static String desc = "Heals 50 HP. Increases defense by 10% for 3 turns | Cost: 70 mana";
    private static String atkDesc = "You are graced by holy benevolence.";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,4,10,3};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Blessing(boolean t) throws InterruptedException
    {
       super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,140,t);
    }
    public static void equip() throws InterruptedException {
    	new Blessing(true);
    }
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		list.add(DivineLove.class);
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(Purify.class))
			return true;
		return false;
	}
}
