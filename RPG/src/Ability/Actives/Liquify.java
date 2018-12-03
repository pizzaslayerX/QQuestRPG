
package Ability.Actives;

import java.util.ArrayList;

import Main.Player;

public class Liquify extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 81;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Liquification";
    private static String desc = "37 poison dmg for 15% of enemy max healh and -15% def. for 2 turns | Cost: 81 Mana";
    private static String atkDesc = "A concoction of the deadliest poisons begins turning the enemy into mush.";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg = false;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,14,37,15,41,15,2};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Liquify() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,90);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new Liquify());
    }
    

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(Dissolve.class))
				return true;
			return false;
		}
}

