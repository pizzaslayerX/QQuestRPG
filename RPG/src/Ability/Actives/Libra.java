package Ability.Actives;

import java.io.Serializable;
import java.util.ArrayList;

import gameplay.Player;

public class Libra extends Special implements Serializable
{
	private static boolean targetAll = false;
    private static int manaCost;
    private static int heal;
    private static int percentHeal;
    private static String name = "Libra";
    private static String desc = "Provides an in-depth analysis of enemies. This action takes time...";
    private static String atkDesc = "You gain a vast amount of knowledge about the enemy";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,17,0,0};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = false;
    
    public Libra(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,0,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Libra(true);
    }
    
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();

		return list;
	}

	@Override
	public boolean isLearnable() {

		return false;
	}
}
