package Ability.Actives;

import Main.Player;

public class Reaper extends Special
{
	private static boolean targetAll = false;
    private static String name = "Reaper's Call";
    private static String desc = "15 Pure dmg, heals 20 HP, +3 dmg for 1 turn. | Cost: 35 Mana";
    private static String atkDesc = "You summon a Reaper to steal the enemy's soul";
    private static int manaCost = 35;
    private static int heal = 20;
    private static int percentHeal = 0;
    private static int dmg = 15;
    private static boolean pureDmg = true;
    private static boolean doesDmg = true;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,6,3,1};
    public static boolean limit = true;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Reaper() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new Reaper());
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
