package Ability.Actives;

import java.util.ArrayList;

import Main.Player;

public class DrainTouch extends Special
{
	private static boolean targetAll = false;
    private static String name = "Draining Touch";
    private static String desc = "Deals 8 dmg and heals 10 HP | Cost: 12 Mana";
    private static String atkDesc = "You tenderly steal the enemy's life";
    private static int manaCost = 12;
    private static int heal = 10;
    private static int percentHeal = 0;
    private static int dmg = 8;
    private static boolean pureDmg;
    private static boolean doesDmg = true;
    private static boolean statusEffect = false;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public DrainTouch() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,15);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new DrainTouch());
    }
    

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			list.add(Enfeeble.class);
			list.add(Poison.class);
			list.add(Reaper.class);
			return list;
		}

		@Override
		public boolean isLearnable() {
			return true;
		}
}
