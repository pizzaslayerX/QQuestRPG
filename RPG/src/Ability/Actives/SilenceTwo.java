package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class SilenceTwo extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 12;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Silence II";
    private static String desc = "Enemies can't use abilities for 3 turns. | Does not use turn | Cost: 12 mana";
    private static String atkDesc = "The enemy's voice is banished to the void.";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,2,0,3};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = false;
    
    public SilenceTwo(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,50,t);
    }
    
    public static void equip() throws InterruptedException {
    	new SilenceTwo(true);
    }
    
      

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			list.add(HellVoid.class);

			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(Silence.class))
				return true;
			return false;
		}
}
