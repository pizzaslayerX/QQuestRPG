package Ability.Actives;

import java.util.ArrayList;

import Main.Player;

public class Extinguish extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 30;
    private static int heal;
    private static int percentHeal;
    private static String name = "Extinguish";
    private static String desc = "+20 Fire Resistance for 3 turns | Costs: 30 mana";
    private static String atkDesc = "You quell any fires that touch you.";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,26,20,3};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Extinguish(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,20,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Extinguish(true);
    }
    
      
		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			list.add(Spray.class);
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(SnowBall.class))
				return true;
			return false;
		}
}
