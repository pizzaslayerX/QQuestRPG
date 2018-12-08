package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class ElectronVeil extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 20;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Electron Shield";
    private static String desc = "+50% shock resistance for 2 turns | Does not use turn | Cost: 20 mana";
    private static String atkDesc = "Quadrillions of electrons swarm your body. You've become the ultimate repellent!";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,28,50,2};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = false;
    
    public ElectronVeil(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,30,t);
    }
    
    public static void equip() throws InterruptedException {
    	new ElectronVeil(true);
    }
    
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(Sparks.class))
			return true;
		return false;
	}
}
