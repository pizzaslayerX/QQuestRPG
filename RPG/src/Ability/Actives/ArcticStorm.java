package Ability.Actives;

import java.util.ArrayList;

import Main.Player;

public class ArcticStorm extends Special
{
	private static boolean targetAll = true;
    private static int manaCost = 160;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Arctic Storm";
    private static String desc = "+20 def for 3 turns. Deals 128 frost dmg over 8 turns to all | Cost: 160 mana";
    private static String atkDesc = "A mighty storm of hail and snow lays waste to the battlefield";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg = false;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,4,20,3,12,16,8};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    
    public ArcticStorm(boolean t) throws InterruptedException
    {
    	super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,300,t);  
    }
   
    public static void equip() throws InterruptedException {
    	new ArcticStorm(true);
    }
    
       


		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			return list;
		}


		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(IceShower.class))
				return true;
			return false;
		}
}
