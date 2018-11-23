package Ability.Actives;

import Main.Player;

public class UberCure extends Special
{
	private static boolean targetAll = false;
    private static String name = "Uber Cure";
    private static String desc = "Heals 60% of max HP without using a turn | Cost: 100 Mana";
    private static String atkDesc = "All of your troubles float away...";
    private static int manaCost = 100;
    private static int heal;
    private static int percentHeal = 60;
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = false;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = false;
    
    public UberCure() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new UberCure());
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
