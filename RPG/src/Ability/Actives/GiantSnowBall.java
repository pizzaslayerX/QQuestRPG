
package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class GiantSnowBall extends Special
{
	private static boolean targetAll = false; 
    private static int manaCost = 48;
    private static int heal = 0;
    private static String name = "Giant Snowball";
    private static String desc = "Deals 22 Frost dmg and -10% frost resist for 2 turns | Costs: 48 mana";
    private static String atkDesc = "A massive snowball rolls towards the enemy. They run in vain.";
    private static int percentHeal = 0;
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,12,22,1,24,10,2};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public GiantSnowBall(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,50,t);
    }
    
    public static void equip() throws InterruptedException {
    	new GiantSnowBall(true);
    }
    
        public static void pause(int t)
    {
        try {
            Thread.sleep(t);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(Gale.class))
				return true;
			return false;
		}
}

