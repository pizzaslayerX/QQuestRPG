package Ability.Actives;

import gameplay.Player;

public class TripleThreat extends Special
{
	private static boolean targetAll = false;
    private static int manaCost = 42;
    private static int heal = 0;
    private static int percentHeal = 0;
    private static String name = "Triple Threat";
    private static String desc = "Silience, Stun, and -10% def for 3 turns. | Costs 42 mana";
    private static String atkDesc = "A storm of curses rains down...";
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {3,3,0,3,2,0,3,41,10,3};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public TripleThreat() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new TripleThreat());
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
