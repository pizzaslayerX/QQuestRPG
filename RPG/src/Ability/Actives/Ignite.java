package Ability.Actives;

import java.util.ArrayList;

import Main.Player;

public class Ignite extends Special
{
	private static boolean targetAll = false;
    private static int percentHeal = 0;
    private static int manaCost = 0;
    private static int heal = 0;
    private static String name = "Ignite";
    private static String desc = "Deals 15 fire dmg over 5 turns";
    private static String atkDesc = "A spark flies from your hands";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,1,3,5};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Ignite() throws InterruptedException
    {
       super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,10);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new Ignite());
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
			list.add(Simmer.class);
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(Burst.class))
				return true;
			return false;
		}
}
