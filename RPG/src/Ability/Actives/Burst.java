package Ability.Actives;
import Run.*;

import java.util.ArrayList;

import Main.Player;
import Monsters.MonsterManager;
public class Burst extends Special
{
	private static boolean targetAll = false;
    private static int percentHeal = 0;
    private static int manaCost = 0;
    private static int heal = 0;
    private static String name = "Burst";
    private static String desc = "Deals 5 pure Dmg without using a turn";
    private static String atkDesc = "You ignite the enemey's soul!";
    private static int dmg = 5;
    private static boolean pureDmg = true;
    private static boolean doesDmg = true;
    private static boolean statusEffect = false;
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = false;
     private static int[] statusVal = {0,0,0};
    public Burst() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,5);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new Burst());
    }
    
        public static void pause(int t)
    {
        try {
            Thread.sleep(t);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			list.add(Ignite.class);
			list.add(Nova.class);
			return list;
		}

		@Override
		public boolean isLearnable() {
			return true;
		}
}
