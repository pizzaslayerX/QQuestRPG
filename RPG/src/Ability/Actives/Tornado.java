package Ability.Actives;

import Main.Player;

public class Tornado extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 101;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Tornado";
    private static String desc = "Hits 15 times. Deals 45-90 dmg. Stuns for 1 turn. Cost: 101 Mana";
    private static String atkDesc = "A twister emerges from the heavens!";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {2,3,0,1,5,15,6};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Tornado() throws InterruptedException
    {
       super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new Tornado());
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
