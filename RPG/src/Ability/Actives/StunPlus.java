package Ability.Actives;

import Main.Player;

public class StunPlus extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 20;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Stun+";
    private static String desc = "For 5 turns, 50% chance to skip enemy's turn. | Costs 20 mana";
    private static String atkDesc = "An intense light engulfs the enemy";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,3,0,5};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public StunPlus() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new StunPlus());
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
