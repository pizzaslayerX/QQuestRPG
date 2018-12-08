package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Eruption extends Special
{
    private static int manaCost = 50;
    private static int heal = 0;
    private static boolean targetAll = false;
    private static int percentHeal = 0;
    private static String name = "Eruption";
    private static String desc = "Does 18 pure damage and inflicts 45 fire damage over 3 turns | Cost: 50 mana";
    private static String atkDesc = "A pool of molten magma shoots up from beneath the enemy's feet.";
    private static int dmg = 18;
    private static boolean pureDmg = true;
    private static boolean doesDmg = true;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,1,15,3};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Eruption(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,80,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Eruption(true);
    }
    
    @Override
   	public ArrayList<Class<? extends Special>> getNewSpecial() {
   		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
   		return list;
   	}

   	@Override
   	public boolean isLearnable() {
   		if(Player.checkAbility(Simmer.class) && Player.checkAbility(Explosion.class))
   			return true;
   		return false;
   	}
}
