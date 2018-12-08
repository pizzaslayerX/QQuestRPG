
package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class FrostBite extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 48;
    private static int heal = 0;
    private static String name = "Frost Bite";
    private static String desc = "Freezes for 1 turn dealing 35 dmg. Disables for 2 turns | Cost: 48 mana";
    private static String atkDesc = "Icy crystals cover the enemy head to toe. They are frozen solid.";
    private static int percentHeal = 0;
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,70,35,1,17,0,2};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public FrostBite(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,60,t);
    }
    
    public static void equip() throws InterruptedException {
    	new FrostBite(true);
    }

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			list.add(ArcticStorm.class);
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(Freeze.class))
				return true;
			return false;
		}
}

