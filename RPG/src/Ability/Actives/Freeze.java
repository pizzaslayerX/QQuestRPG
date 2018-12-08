
package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Freeze extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 20;
    private static int heal = 0;
    private static String name = "Freeze";
    private static String desc = "Freezes for 2 turns dealing 10 dmg. | Cost: 20 mana";
    private static String atkDesc = "Icy crystals cover the enemy head to toe. They are frozen solid.";
    private static int percentHeal = 0;
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,70,10,2};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Freeze(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,40,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Freeze(true);
    }

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			list.add(Glacier.class);
			list.add(AbsoluteZero.class);
			list.add(FrostBite.class);
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(SnowBall.class))
				return true;
			return false;
		}
}

