package Ability.Actives;

import java.util.ArrayList;

import Main.Player;

public class Enfeeble extends Special
{
	private static boolean targetAll = false;
    private static String name = "Enfeeble";
    private static String desc = "-20% enemy dmg for 2 turns | Cost: 28 Mana";
    private static String atkDesc = "The enemy is debilitated.";
    private static int manaCost = 28;
    private static int heal;
    private static int percentHeal = 0;
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,43,20,2};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Enfeeble() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,30);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new Enfeeble());
    }
    

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			list.add(Cripple.class);
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(DrainTouch.class))
				return true;
			return false;
		}
}
