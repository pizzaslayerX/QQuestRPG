package Ability.Actives;

import java.util.ArrayList;

import Main.Player;

public class CrossSlash extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 0;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Cross Slash";
    private static String desc = "Hits 4 times. Deals 20-44 dmg";
    private static String atkDesc = "You skillfully slash the enemy";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg = false;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,5,11,4};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public CrossSlash() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);
    }
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new CrossSlash());
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
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public boolean isLearnable() {
			// TODO Auto-generated method stub
			return false;
		}
}
