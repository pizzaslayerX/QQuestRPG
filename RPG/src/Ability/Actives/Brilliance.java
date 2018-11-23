package Ability.Actives;

import Main.Player;

public class Brilliance extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 28;
    private static int heal = 16;
    private static int percentHeal = 0;
    private static String name = "Brilliance";
    private static String desc = "Heals 16 HP. Stuns for 2 turns | Costs 28 mana";
    private static String atkDesc = "A warming glow overwhelms the enemy";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,3,0,2};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Brilliance() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);
    }
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new Brilliance());
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
