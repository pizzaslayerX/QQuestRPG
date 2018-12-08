package Ability.Actives;

import java.util.ArrayList;

import gameplay.Player;

public class SuperNova extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 210;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Super Nova";
    private static String desc = "80 pure Dmg. Stuns for 2 turns. 135 fire dmg over 5 turns | Costs: 210 mana";
    private static String atkDesc = "The power of the sun incinerates the enemy";
    private static int dmg = 80;
    private static boolean pureDmg = true;
    private static boolean doesDmg = true;
    private static boolean statusEffect = true;
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
     private static int[] statusVal = {2,1,27,5,3,0,2};
    public SuperNova(boolean t) throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll,0,t);
    }
    
    public static void equip() throws InterruptedException {
    	new SuperNova(true);
    }
    
    @Override
   	public ArrayList<Class<? extends Special>> getNewSpecial() {
   		ArrayList<Class<? extends Special>> list = new ArrayList<Class<? extends Special>>();

   		return list;
   	}

   	@Override
   	public boolean isLearnable() {

   		return false;
   	}
}
