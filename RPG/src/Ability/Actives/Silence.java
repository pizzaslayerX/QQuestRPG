package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Silence extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 0;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Silence";
    private static String desc = "Enemies can't use abilities for 1 turn. Does not use a turn.";
    private static String atkDesc = "You mute the enemy's voice!";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,2,0,1};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = false;
    
    
    public Silence(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,20,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Silence(true);
    }
    
      

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			list.add(SilenceTwo.class);

			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(Insulate.class))
				return true;
			return false;
		}
}
