package Ability.Actives;

import gameplay.Player;

public class Eruption extends Special
{
    private static int manaCost = 50;
    private static int heal = 0;
    private static boolean targetAll = false;
    private static int percentHeal = 0;
    private static String name = "Eruption";
    private static String desc = "Does 12 pure damage and inflicts 45 fire damage over 3 turns | Costs 50 mana";
    private static String atkDesc = "A pool of molten magma shoots up from beneath the enemy's feet.";
    private static int dmg = 12;
    private static boolean pureDmg = true;
    private static boolean doesDmg = true;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,1,15,3};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Eruption() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new Eruption());
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
