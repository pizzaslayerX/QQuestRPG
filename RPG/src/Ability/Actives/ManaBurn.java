package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class ManaBurn extends Special
{
	private static boolean targetAll = false;
    private static int manaCost;
    private static int heal;
    private static int percentHeal;
    private static String name = "Mana Burn";
    private static String desc = "Deals remaining mana as pure dmg. | Cost: All Mana";
    private static String atkDesc = "You channel your mana into a destructive beam";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,7,0,0};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public ManaBurn(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,0,t);
    }
    
    public static void equip() throws InterruptedException {
    	new ManaBurn(true);
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
