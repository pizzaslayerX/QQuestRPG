
package Ability.Actives;

import java.util.ArrayList;

import Main.Player;

public class SnowBall extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 0;
    private static int heal = 0;
    private static String name = "Snowball";
    private static String desc = "Deals 6 frost dmg";
    private static String atkDesc = "You pelt the enemy with fluffy snow";
    private static int percentHeal = 0;
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,12,6,1};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public SnowBall() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,5);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new SnowBall());
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
			list.add(Gale.class);
			list.add(Fortify.class);
			list.add();
		}

		@Override
		public boolean isLearnable() {
			return true;
		}
}

