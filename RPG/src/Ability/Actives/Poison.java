
package Ability.Actives;

import Main.Player;

public class Poison extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 0;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Poison";
    private static String desc = "Deals 3 poison dmg per turn until 10% of enemy max health is lost from posion dmg.";
    private static String atkDesc = "A slip some ew into the enemy's food!";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg = false;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,14,3,10};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Poison() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new Poison());
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

