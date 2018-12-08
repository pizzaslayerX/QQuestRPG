package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class FireShield extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 40;
    private static int heal;
    private static int percentHeal;
    private static String name = "Fiery Aura";
    private static String desc = "+5% Def. for 5 turns and deals 50 fire dmg over 5 turns | Costs 40 mana";
    private static String atkDesc = "A coat of protective flames surround you.";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,4,8,5,1,10,5};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public FireShield(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,0,t);
    }
    
    public static void equip() throws InterruptedException {
    	new FireShield(true);
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
