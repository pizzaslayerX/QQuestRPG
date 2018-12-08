
package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Glacier extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 65;
    private static int heal = 0;
    private static String name = "Glaciel Prison";
    private static String desc = "Freezes, +20% def, -25% Frost Resist for 3 turns | Cost: 65 mana";
    private static String atkDesc = "The enemy becomes trapped in a thick layer of ice.";
    private static int percentHeal = 0;
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {3,70,0,3,40,20,3,24,25,3};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Glacier(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,105,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Glacier(true);
    }

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(Freeze.class) && Player.checkAbility(GiantSnowBall.class))
				return true;
			return false;
		}
}

