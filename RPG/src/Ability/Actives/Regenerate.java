package Ability.Actives;

import Main.Player;

public class Regenerate extends Special
{
	private static boolean targetAll = false;
    private static String name = "Regenerate";
    private static String desc = "Heals 40 HP over 5 turns | Cost: 35 Mana";
    private static String atkDesc = "Your body's healing process has tripled!";
    private static int manaCost = 35;
    private static int heal;
    private static int percentHeal;
    private static int dmg;
    private static boolean pureDmg;
    private static boolean doesDmg;
    private static boolean statusEffect = true;
    //{Total Effects,Status Id,dmg,Duration}
    private static int[] statusVal = {1,8,8,5};
    public static boolean limit = false;
    public static boolean use;
    public static boolean useTurn = true;
    
    public Regenerate() throws InterruptedException
    {
        super(name,desc,atkDesc,dmg,pureDmg,doesDmg,statusEffect,limit,use,useTurn,statusVal,heal,manaCost,percentHeal,targetAll);
    }
    
    public static void equip() throws InterruptedException {
    	Player.abilities.add(new Regenerate());
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
