package Ability.Actives;
import java.util.ArrayList;

import backend.*;
import gameplay.Player;
import monsters.MonsterManager;
public class Deshell extends Special
{
	private static boolean targetAll = false;
    private static int percentHeal = 0;
    private static int manaCost = 23;
    private static int heal = 0;
    private static String name = "Deshell";
    private static String desc = "-20% def. for 3 turns | Cost: 23 mana";
    private static String atkDesc = "You crack the enemy's defenses!";
    private static int dmg;
    private static boolean pureDmg = false;
    private static boolean doesDmg = false;
    private static boolean statusEffect = true;
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
     private static int[] statusVal = {1,41,20,3};
    public Deshell(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,35,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Deshell(true);
    }
    

	@Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		return list;
	}

	@Override
	public boolean isLearnable() {
		if(Player.checkAbility(SwordArt.class))
			return true;
		return false;
	}
}
