package Ability.Actives;
import monsters.MonsterManager;

import java.util.ArrayList;

import gameplay.Player;
public class Insulate extends Special
{
	private static boolean targetAll = false;
    private static int percentHeal = 0;
    private static int manaCost = 30;
    private static int heal = 0;
    private static String name = "Insulate";
    private static String desc = "+20% Shock Resistance for 3 turns | Cost: 30 mana";
    private static String atkDesc = "You become much more resistant to electricity.";
    private static int dmg = 0;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
     private static int[] statusVal = {1,28,20,3};
    public Insulate(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,20,t);
    }
    
    public static void equip() throws InterruptedException {
    	new Insulate(true);
    }
    
      

		@Override
		public ArrayList<Class<? extends Special>> getNewSpecial() {
			ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();
			list.add(Rawflesia.class);
			list.add(Silence.class);
			list.add(Vehemency.class);
			list.add(Prism.class);
			return list;
		}

		@Override
		public boolean isLearnable() {
			if(Player.checkAbility(Burst.class))
				return true;
			return false;
		}
}
