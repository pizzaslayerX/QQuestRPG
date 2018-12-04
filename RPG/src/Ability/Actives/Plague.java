package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Plague extends Special
{
	private static boolean targetAll = true;
    private static int manaCost = 0;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Plague";
    private static String desc = "Deals 8 poison dmg per turn for 25% of max health | Targets all enemies";
    private static String atkDesc = "A deadly pathogen has been unleashed!";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg = false;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,14,8,25};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Plague(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,45,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Plague(true);
    }
      
    
    	@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			list.add(VirulentPlague.class);
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(Poison.class))
				return true;
			return false;
		}
}
