package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Gale extends Special
{
	private static boolean targetAll = true;
    private static int percentHeal = 0;
    private static int manaCost = 14;
    private static int heal = 0;
    private static String name = "Icy Gale";
    private static String desc = "9 Frost dmg to all targets | Costs: 14 mana";
    private static String atkDesc = "A chilly wind sweeps through the battlefield";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,12,9,1};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Gale(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,20,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Gale(true);
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
			list.add(GiantSnowBall.class);
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(SnowBall.class))
				return true;
			return false;
		}
}
