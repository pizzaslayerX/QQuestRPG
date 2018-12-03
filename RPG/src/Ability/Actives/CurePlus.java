package Ability.Actives;

import java.util.ArrayList;

import Main.Player;

public class CurePlus extends Special
{
	private static boolean targetAll = false;
    private static String name = "Cure+";
    private static String desc = "Heals 25% of max HP without using a turn | Cost: 55 Mana";
    private static String atkDesc = "You feel a hella lot better...";
    private static int manaCost = 55;
    private static int heal;
    private static int percentHeal = 25;
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = false;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = false;
    
    public CurePlus(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,50,t);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new CurePlus(true));
    }
    
      

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			list.add(Brilliance.class);
			list.add(Regenerate.class);
			list.add(UberCure.class);
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(Cure.class)) {
				return true;
			}
			return false;
		}
}
