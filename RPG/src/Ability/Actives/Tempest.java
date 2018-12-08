package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Tempest extends Special
{
	private static boolean targetAll = true;
    private static int manaCost = 250;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Tempest";
    private static String desc = "Everyone: +50% Fire Resist, -30% Shock Resist, -25% def, for 6 turns. All enemies: 84 Shock dmg over 6 turns. | Cost: 250 mana";
    private static String atkDesc = "You summon a storm unlike any other. The sky darkens as the end begins.";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {7,31,30,6,26,50,6,42,25,6,20,50,6,25,30,6,41,25,6,13,14,6};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Tempest(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,330,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Tempest(true);
    }
    
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(Tornado.class) && Player.checkAbility(ReverentThunder.class) && Player.checkAbility(Spray.class))
			return true;
		return false;
	}
}
