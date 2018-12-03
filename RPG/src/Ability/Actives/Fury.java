package Ability.Actives;

import java.util.ArrayList;

import Main.Player;

public class Fury extends Special
{
	private static boolean targetAll = false;
    private static int manaCost;
    private static int heal;
    private static int percentHeal;
    private static String name = "Fury";
    private static String desc = "+18 dmg and +13% defense for 1 turn";
    private static String atkDesc = "Everything turns red. Your rage is too great!";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,6,18,1,4,13,1};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Fury() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,48);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new Fury());
    }
    

	@Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		list.add(Feint.class);
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(Fury.class))
			return true;
		return false;
	}
}
