package Ability.Actives;

import java.util.ArrayList;

import Main.Player;

public class Spray extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 45;
    private static int heal;
    private static int percentHeal;
    private static String name = "Spray";
    private static String desc = "-15 enemy Ice and Shock Resistance: 3 turns. Does not use turn | Costs: 45 mana";
    private static String atkDesc = "The enemy is soaked!";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,24,15,3,25,15,3};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = false;
    
    public Spray() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,45);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new  Spray());
    }
    

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(Extinguish.class))
				return true;
			return false;
		}
}
