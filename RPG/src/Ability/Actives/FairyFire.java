package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class FairyFire extends Special
{
	private static boolean targetAll = false;
    private static int percentHeal;
    private static int manaCost = 78;
    private static int heal;
    private static String name = "Fairy Fire";
    private static String desc = "Deals 80 fire dmg over 5 turns and Heals 80 HP over 5 turns | Cost: 78 Mana";
    private static String atkDesc = "A red and green fairy comes to your aid!";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,1,16,5,8,16,5};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public FairyFire(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,0,t);
    }
    
    public static void equip() throws InterruptedException {
    	new FairyFire(true);
    }
  
    
      

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		

			return list;
		}

		@Override
		public boolean isLearnable() {
	
			return false;
		}
}
