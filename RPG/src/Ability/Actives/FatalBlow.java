package Ability.Actives;

import Main.Player;

public class FatalBlow extends Special
{
	private static boolean targetAll = false;
    private static int manaCost;
    private static int heal;
    private static int percentHeal;
    private static String name = "Fatal Blow";
    private static String desc = "Deals 50 dmg without using a turn";
    private static String atkDesc = "You strike the enemy's weak spot!";
    private static int dmg = 50;
    private static boolean pureDmg;
    private static boolean doesDmg = true;
    private static boolean statusEffect = false;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal;
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = false;
    
    public FatalBlow() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new FatalBlow());
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
