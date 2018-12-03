package Ability.Actives;

import java.util.ArrayList;

import Main.Player;

public class Untouchable extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 100;
    private static int heal;
    private static int percentHeal;
    private static String name = "Untouchable";
    private static String desc = "+40 def for 2 turns. Silences for 2 turns. | Cost: 100 Mana";
    private static String atkDesc = "You stall for time.";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,4,40,2,2,0,2};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Untouchable(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,120,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Untouchable(true);
    }
    
        

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			list.add(Invincibility.class);
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(Fortify.class))
				return true;
			return false;
		}
}

