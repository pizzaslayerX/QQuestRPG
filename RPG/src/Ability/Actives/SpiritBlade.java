package Ability.Actives;
import java.util.ArrayList;

import backend.*;
import gameplay.Player;
import monsters.MonsterManager;
public class SpiritBlade extends Special
{
	private static boolean targetAll = false;
    private static int percentHeal = 0;
    private static int manaCost = 0;
    private static int heal = 0;
    private static String name = "Spirit Blade";
    private static String desc = "Deals 25 dmg and Silences for 2 turn without using a turn";
    private static String atkDesc = "Your weapon demands blood!";
    private static int dmg = 25;
    private static boolean pureDmg = false;
    private static boolean doesDmg = true;
    private static boolean statusEffect = true;
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = false;
     private static int[] statusVal = {1,2,0,2};
    public SpiritBlade(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,40,t);
    }
    
    public static void equip() throws InterruptedException {
    	new SpiritBlade(true);
    }

	@Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		list.add(Focus.class);
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(SwordArt.class))
			return true;
		return false;
	}
}
