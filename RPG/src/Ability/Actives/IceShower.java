package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class IceShower extends Special
{
	private static boolean targetAll = false;
    private static int percentHeal = 0;
    private static int manaCost = 45;
    private static int heal = 0;
    private static String name = "Icicle Shower";
    private static String desc = "Deals 24 frost dmg. Hits another 7 times dealing 14-28 dmg | Costs: 45 mana";
    private static String atkDesc = "Super sharp ice spikes rain down";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,5,4,7,12,24,1};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public IceShower(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,100,t);
    }
    
    public static void equip() throws InterruptedException {
    	new IceShower(true);
    }
    
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		list.add(ArcticStorm.class);
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(FrostBite.class))
			return true;
		return false;
	}
}
