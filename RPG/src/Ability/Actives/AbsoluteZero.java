
package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class AbsoluteZero extends Special
{
	private static boolean targetAll = true;
    private static int manaCost = 60;
    private static int heal = 0;
    private static String name = "Absolute Zero";
    private static String desc = "Freezes for 2 turns dealing 30 dmg. | Targets All Enemies | Cost: 60 mana";
    private static String atkDesc = "Icy crystals cover the enemy head to toe. They are frozen solid.";
    private static int percentHeal = 0;
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,70,30,2};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public AbsoluteZero(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,120,t);
    }
    
    public static void equip() throws InterruptedException {
    	new AbsoluteZero(true);
    }

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(Freeze.class))
				return true;
			return false;
		}
}

