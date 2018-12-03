package Ability.Actives;

import java.util.ArrayList;

import Main.Player;

public class VirulentPlague extends Special
{
	private static boolean targetAll = true;
    private static String name = "Virulent Plague";
    private static String desc = "Targets all enemies | -15% dmg for 3 turns. 14 poison dmg per turn for 20% of max health | Cost: 38 Mana";
    private static String atkDesc = "An ancient plague is released. No cure exists.";
    private static int manaCost = 38;
    private static int heal;
    private static int percentHeal = 0;
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,43,15,3,14,14,20};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public VirulentPlague(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,110,t);
    }
    
    public static void equip() throws InterruptedException {
    	new VirulentPlague(true);
    }
    

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			list.add(Epidemic.class);
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(Cripple.class) && Player.checkAbility(Plague.class))
				return true;
			return false;
		}
}
