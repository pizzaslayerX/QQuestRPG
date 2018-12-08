package Ability.Actives;
import monsters.MonsterManager;

import java.util.ArrayList;

import gameplay.Player;
public class Rawflesia extends Special
{
	private static boolean targetAll = false;
    private static int percentHeal = 0;
    private static int manaCost = 30;
    private static int heal = 0;
    private static String name = "Rawflesia";
    private static String desc = "-30% Fire Resist for 2 turns | Cost: 30 mana";
    private static String atkDesc = "You rend the flesh from the enemy, leaving their body exposed.";
    private static int dmg = 0;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
     private static int[] statusVal = {1,23,30,2};
    public Rawflesia(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,45,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Rawflesia(true);
    }
    
      

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(Insulate.class))
				return true;
			return false;
		}
}
