package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Immolate extends Special
{
	private static boolean targetAll = false;
    private static int percentHeal = 0;
    private static int manaCost = 40;
    private static int heal = 0;
    private static String name = "Immolate";
    private static String desc = "Deals 35 fire dmg over 5 turns. -10% Fire Resist and def for 5 turns | Cost: 40 mana";
    private static String atkDesc = "A spark flies from your hands";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {3,1,7,5,23,10,5,41,10,5};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Immolate(boolean t) throws InterruptedException
    {
       super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,55,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Immolate(true);
    }
    

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			list.add(EternalFlames.class);
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(Ignite.class))
				return true;
			return false;
		}
}
