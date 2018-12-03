
package Ability.Actives;

import java.util.ArrayList;

import Main.Player;

public class Poison extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 0;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Poison";
    private static String desc = "Deals 3 poison dmg per turn until 10% of enemy max health is lost from posion dmg.";
    private static String atkDesc = "You slip some ew into the enemy's food!";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg = false;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,14,3,10};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Poison(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,20,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Poison(true);
    }
    
		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			list.add(Plague.class);
			list.add(Dissolve.class);
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(DrainTouch.class))
				return true;
			return false;
		}
}

