package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class ArcticStorm extends Special
{
	private static boolean targetAll = true;
    private static int manaCost = 160;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Arctic Storm";
    private static String desc = "Freeze for 1 turn. -40% Speed for 8 turns, Deals 128 Frost dmg over 8 turns | Targets All Enenmies | Cost: 160 mana";
    private static String atkDesc = "A mighty storm of hail and snow lays waste to the battlefield.";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg = false;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {3,70,0,1,12,16,8,35,40,8};
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
			if(Player.checkAbility(IceShower.class) && Player.checkAbility(FrostBite.class))
				return true;
			return false;
		}
}
