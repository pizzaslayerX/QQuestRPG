package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Epidemic extends Special
{
	private static boolean targetAll = true;
    private static String name = "Epidemic";
    private static String desc = "Targets all enemies | -35% dmg for 3 turns. 21 poison dmg per turn for 40% of max health. Stun for 1 turn. | Cost: 75 Mana";
    private static String atkDesc = "The worst diseases are unleashed. You await their screams of agony.";
    private static int manaCost = 75;
    private static int heal;
    private static int percentHeal = 0;
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {3,43,35,4,14,21,40,3,0,1};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Epidemic(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,285,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Epidemic(true);
    }
    

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(VirulentPlague.class))
				return true;
			return false;
		}
}
