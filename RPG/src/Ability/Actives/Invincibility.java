package Ability.Actives;

import Main.Player;

public class Invincibility extends Special
{
	private static boolean targetAll = false;
    private static int manaCost;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Invincibility";
    private static String desc = "+100 def and Silences for 1 turn. Does not use turn.";
    private static String atkDesc = "God Mode = true";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,4,100,1,2,0,1};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = false;
    
    public Invincibility() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new Invincibility());
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

