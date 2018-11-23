package Ability.Actives;

import Main.Player;

public class Simmer extends Special
{
	private static boolean targetAll = true;
    private static int manaCost = 0;
    private static int heal = 0;
    private static String name = "Simmer";
    private static String desc = "Deals 21 fire dmg over 3 turns to all";
    private static String atkDesc = "Hot liquid engulfs the battlefield";
    private static int percentHeal = 0;
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,1,7,3};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Simmer() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new Simmer());
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
