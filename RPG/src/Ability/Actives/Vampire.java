package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Vampire extends Special
{
	private static boolean targetAll = true;
    private static int manaCost = 0;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Vampiric Cull";
    private static String desc = "Deals 10% of enemies' max health as bleed dmg over 5 turns. | Targets All Enemies | Cost: 55 HP";
    private static String atkDesc = "You harvest the blood of your enemies!";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {0,0,0,0};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Vampire(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,100,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Vampire(true);
    }
    
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(Karmazatz.class))
			return true;
		return false;
	}
}
