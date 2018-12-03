package Ability.Actives;

import java.util.ArrayList;

import Main.Player;

public class Cripple extends Special
{
	private static boolean targetAll = false;
    private static String name = "cripple";
    private static String desc = "-30% enemy dmg for 3 turns. Stun for 1 turn | Cost: 50 Mana";
    private static String atkDesc = "The enemy's limbs become lame. They can hardly move.";
    private static int manaCost = 50;
    private static int heal;
    private static int percentHeal = 0;
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,43,30,3,3,0,1};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Cripple(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,60,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Cripple(true);
    }
    

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			list.add(VirulentPlague.class);
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(Enfeeble.class))
				return true;
			return false;
		}
}
