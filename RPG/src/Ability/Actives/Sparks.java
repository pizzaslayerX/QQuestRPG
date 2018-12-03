package Ability.Actives;

import java.util.ArrayList;

import Main.Player;

public class Sparks extends Special
{
	private static boolean targetAll = false;
    private static int percentHeal = 0;
    private static int manaCost = 0;
    private static int heal = 0;
    private static String name = "Sparky Sparks";
    private static String desc = "Deals 9 shock dmg over 3 turns. Does not use a turn";
    private static String atkDesc = "*zap* *zip* *zoom*";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,13,3,3};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = false;
    
    public Sparks(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,5,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Sparks(true);
    }
    
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		list.add(StaticShock.class);
		list.add(Stun.class);
		list.add(ElectronVeil.class);
		list.add(ThermoElectricity.class);
		return list;
	}

	@Override
	public boolean isLearnable() {
		return true;
	}
}
