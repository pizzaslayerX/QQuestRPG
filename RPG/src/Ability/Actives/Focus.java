package Ability.Actives;

import Main.Player;

public class Focus extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 27;
    private static int heal;
    private static int percentHeal = 12;
    private static String name = "Focus";
    private static String desc = "Heals 12% of HP and +5 dmg for 2 turns. | Costs 27 mana";
    private static String atkDesc = "The world slows down. You regain your compsure";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,6,5,2};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Focus() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new  Focus());
    }
    
        public static void pause(int t)
    {
        try {
            Thread.sleep(t);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
