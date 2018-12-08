package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

//RETIRED CLASS.

public class Polymorph extends Special
{
	private static boolean targetAll = false;
    private static int manaCost;
    private static int heal;
    private static int percentHeal;
    private static String name = "Polymorph";
    private static String desc = "Gain enemy stats for 3 turns. Does not use turn.";
    private static String atkDesc = "Your body begins to change!!!";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,11,0,3};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = false;
    
    public Polymorph(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,0,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Polymorph(true);
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
