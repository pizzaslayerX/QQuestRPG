package Ability.Actives;
import Run.*;

import java.util.ArrayList;

import Main.Player;
import Monsters.MonsterManager;
public class SwordArt extends Special
{
	private static boolean targetAll = false;
    private static int percentHeal = 0;
    private static int manaCost = 0;
    private static int heal = 0;
    private static String name = "Sword Art";
    private static String desc = "Deals 13 dmg without using a turn";
    private static String atkDesc = "You majestically assault the enemy!";
    private static int dmg = 13;
    private static boolean pureDmg = false;
    private static boolean doesDmg = true;
    private static boolean statusEffect = false;
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = false;
     private static int[] statusVal = {0,0,0};
    public SwordArt() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,12);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new SwordArt());
    }
    

	@Override
	public ArrayList<Class<? extends Special>> getNewSpecial() {
		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
		list.add(Deshell.class);
		list.add(SpiritBlade.class);
		list.add(BackKick.class);
		return list;
	}

	@Override
	public boolean isLearnable() {
			return true;
	}
}
