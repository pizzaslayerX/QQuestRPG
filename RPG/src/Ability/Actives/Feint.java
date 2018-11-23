package Ability.Actives;

import Main.Player;

public class Feint extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 0;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Feint";
    private static String desc = "+35 dmg for 2 turns. Stuns for 1 turn. Costs 20 HP.";
    private static String atkDesc = "Purposefully getting hit leaves the enemy vulnerable!";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg = false;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {3,6,35,2,9,20,0,3,0,1};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Feint() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new Feint());
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
