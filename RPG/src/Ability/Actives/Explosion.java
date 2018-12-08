package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class Explosion extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 0;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Explosion";
    private static String desc = "Deals 45 pure Dmg without using a turn";
    private static String atkDesc = "The energy of the sun is unleashed.";
    private static int dmg = 45;
    private static boolean pureDmg = true;
    private static boolean doesDmg = true;
    private static boolean statusEffect = false;
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = false;
     private static int[] statusVal = {0,0,0};
    public Explosion(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,60,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Explosion(true);
    }
    
    @Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		list.add(Eruption.class);
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(Nova.class))
			return true;
		return false;
	}
}
