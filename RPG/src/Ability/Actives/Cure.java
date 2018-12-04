package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Cure extends Special
{
	private static boolean targetAll = false;
    private static String name = "Cure";
    private static String desc = "Heals 10% of max HP without using a turn | Cost: 25 Mana";
    private static String atkDesc = "Your wounds are magically treated";
    private static int manaCost = 25;
    private static int heal;
    private static int percentHeal = 10;
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = false;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = false;
    
    public Cure(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,0,t);
    }
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new Cure(true));
    }
    
		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			list.add(CurePlus.class);
			return list;
		}
		@Override
		public boolean isLearnable() {
			return true;
		}
        
        
}
