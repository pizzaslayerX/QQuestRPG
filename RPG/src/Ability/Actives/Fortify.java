package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Fortify extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 25;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Fortify";
    private static String desc = "Increases defense by 15% for 3 turns | Costs: 25 mana";
    private static String atkDesc = "Your skin thickens... A LOT";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,4,15,3};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Fortify(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,15,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Fortify(true);
    }
    

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			list.add(Untouchable.class);
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(SnowBall.class))
				return true;
			return false;
		}
}
