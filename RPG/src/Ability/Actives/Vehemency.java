package Ability.Actives;

import java.util.ArrayList;

import main.Player;

public class Vehemency extends Special
{
	private static boolean targetAll = false;
    private static int percentHeal = 0;
    private static int manaCost = 0;
    private static int heal = 0;
    private static String name = "Vehemency";
    private static String desc = "+12% frost and shock resist for 5 turns. +5 dmg for 3 turns.";
    private static String atkDesc = "A spark flies from your hands";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {3,1,3,5};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Vehemency(boolean t) throws InterruptedException
    {
       super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,35,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Vehemency(true);
    }
       

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(Insulate.class))
				return true;
			return false;
		}
}
