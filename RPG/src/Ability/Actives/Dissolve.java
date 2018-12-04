
package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Dissolve extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 30;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Dissolving Fumes";
    private static String desc = "19 poison dmg for 10% of enemy max health | Cost: 30 Mana";
    private static String atkDesc = "A cloud of noxious gas quickly dissolves the enemy";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg = false;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,14,19,10};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Dissolve(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,50,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Dissolve(true);
    }
    

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			list.add(Liquify.class);
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(Poison.class))
				return true;
			return false;
		}
}

